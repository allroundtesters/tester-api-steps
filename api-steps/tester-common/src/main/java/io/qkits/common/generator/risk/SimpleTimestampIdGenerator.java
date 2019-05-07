package io.qkits.common.generator;



import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class SimpleTimestampIdGenerator implements RiskIdGenerator {

  private static AtomicLong counter = new AtomicLong(1);
  private static final String pattern = "yyyyMMddHHmmssSSS";
  private static String ip = "000";

  static {
    try {
      boolean bFindIP = false;
      Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
      InetAddress inetAddress = null;
      while (netInterfaces.hasMoreElements()) {
        if (bFindIP) {
          break;
        }
        NetworkInterface ni = netInterfaces.nextElement();
        Enumeration<InetAddress> ips = ni.getInetAddresses();
        while (ips.hasMoreElements()) {
          inetAddress = ips.nextElement();
          if (inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(":") == -1) {
            bFindIP = true;
            break;
          }
        }
      }
      if (inetAddress != null) {
        ip = inetAddress.getHostAddress();
        ip = ip.substring(ip.lastIndexOf(".") + 1, ip.length());
        int length = ip.length();
        if (length >= 3) {
          ip = ip.substring(0, 3);
        } else {
          ip = String.format("%03d", Integer.parseInt(ip));
        }
      }
    } catch (Exception e) {
      ip = String.format("%03d", new Random().nextInt(999));

    }
  }

  /**
   * timestamp:  yyyyMMddhhssmm ip      :     xxx counter :     xxx
   */
  @Override
  public String getId() {
    String suffix = new SimpleDateFormat(pattern).format(new Date());
    if (counter.longValue() > 9999) {
      counter = new AtomicLong(1);
    }
    String result = suffix + ip + String.format("%04d", counter.longValue());
    counter.getAndIncrement();
    return result;
  }

  /**
   * timestamp:  yyyyMMddhhssmm ip      :     xxx counter :     xxxx
   */
  @Override
  public String getId(String prefix) {
    return prefix + "_" + getId();
  }
}
