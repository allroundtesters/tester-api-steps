//package io.qkits.common.utils;
//
//import javax.servlet.http.HttpServletRequest;
//
//
//public class NetworkUtils {
//
//  private static final String UNKNOWN = "unknown";
//
//  public static String getIpAddress(HttpServletRequest request) {
//    // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
//
//    String ip = request.getHeader("X-Forwarded-For");
//
//    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//      if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//        ip = request.getHeader("Proxy-Client-IP");
//      }
//      if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//        ip = request.getHeader("WL-Proxy-Client-IP");
//      }
//      if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//        ip = request.getHeader("HTTP_CLIENT_IP");
//      }
//      if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//      }
//      if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//        ip = request.getRemoteAddr();
//      }
//    } else if (ip.length() > 15) {
//      String[] ips = ip.split(",");
//      for (String strIp : ips) {
//        if (!(UNKNOWN.equalsIgnoreCase(strIp))) {
//          ip = strIp;
//          break;
//        }
//      }
//    }
//    return ip;
//  }
//}
