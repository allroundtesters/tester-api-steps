package io.qkits.common.utils.codec;

import java.util.Base64;

/**
 * @author patrick
 */
public class Base64Util {
    public static byte[] decryptBASE64(String key) {
        return Base64.getMimeDecoder().decode(key);
    }

    public static String encryptBASE64(byte[] key) {
        return Base64.getMimeEncoder().encodeToString(key);
    }
}