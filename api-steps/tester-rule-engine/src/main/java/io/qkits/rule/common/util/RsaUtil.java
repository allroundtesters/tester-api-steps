package io.qkits.rule.common.util;

import javax.crypto.Cipher;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;


public class RsaUtil {
    public static final String KEY_ALGORITHM = "RSA";

    public static byte[] encryptByPublicKey(byte[] dataBytes, String publicKey, String publicKeyAlgorithm) throws Exception {
        byte[] keyBytes = Base64Util.decryptBASE64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPublicKey publicK = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance(publicKeyAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        return encrypt(dataBytes, cipher, publicK);
    }

    public static String encryptByPublicKey(String data, String publicKey, String publicKeyAlgorithm) throws Exception {
        return Base64Util.encryptBASE64(encryptByPublicKey(data.getBytes(), publicKey, publicKeyAlgorithm));
    }

    public static String[] encryptSliceByPublicKey(String data, String publicKey, String publicKeyAlgorithm) throws Exception {
        List<String> results = new ArrayList<>();
        int idx = 0;
        while (idx < data.length()) {
            String cur = data.substring(idx, Math.min(idx + 100, data.length()));
            results.add(Base64Util.encryptBASE64(encryptByPublicKey(cur.getBytes(), publicKey, publicKeyAlgorithm)));
            idx = idx + 100;
        }
        return results.toArray(new String[results.size()]);
    }

    public static byte[] decryptByPrivateKey(byte[] dataBytes, String privateKey, String privateKeyAlgorithm) throws Exception {
        byte[] keyBytes = Base64Util.decryptBASE64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPrivateKey privateK = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(privateKeyAlgorithm);
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        return decrypt(dataBytes, cipher, privateK);
    }

    public static byte[] decryptByPrivateKey(String data, String privateKey, String privateKeyAlgorithm) throws Exception {
        return decryptByPrivateKey(Base64Util.decryptBASE64(data), privateKey, privateKeyAlgorithm);
    }

    public static String decryptSliceByPrivateKey(String[] dataArr, String privateKey, String privateKeyAlgorithm) throws Exception {
        String result = "";
        for (String data : dataArr) {
            result += new String(decryptByPrivateKey(Base64Util.decryptBASE64(data), privateKey, privateKeyAlgorithm), "UTF-8").trim();
        }
        return result;
    }

    public static byte[] encryptByPrivateKey(byte[] dataBytes, String privateKey, String privateKeyAlgorithm) throws Exception {
        byte[] keyBytes = Base64Util.decryptBASE64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPrivateKey privateK = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(privateKeyAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        return encrypt(dataBytes, cipher, privateK);
    }

    public static String encryptByPrivateKey(String data, String privateKey, String privateKeyAlgorithm) throws Exception {
        return Base64Util.encryptBASE64(encryptByPrivateKey(data.getBytes(), privateKey, privateKeyAlgorithm));
    }

    public static byte[] decryptByPublicKey(byte[] dataBytes, String publicKey, String publicKeyAlgorithm) throws Exception {
        byte[] keyBytes = Base64Util.decryptBASE64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPublicKey publicK = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance(publicKeyAlgorithm);
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        return decrypt(dataBytes, cipher, publicK);
    }

    public static byte[] decryptByPublicKey(String data, String publicKey, String publicKeyAlgorithm) throws Exception {
        return decryptByPublicKey(Base64Util.decryptBASE64(data), publicKey, publicKeyAlgorithm);
    }

    private static byte[] encrypt(byte[] dataBytes, Cipher cipher, RSAKey rsaKey) throws Exception {
        int bitLength = rsaKey.getModulus().bitLength();
        // 1024 / 8 - 11(padding) = 117
        int chunkSize = bitLength / 8 - 11;
        int encSize = (int) (Math.ceil(dataBytes.length / Double.valueOf(chunkSize)) * (bitLength / 8));
        int idx = 0;
        ByteBuffer buf = ByteBuffer.allocate(encSize);
        while (idx < dataBytes.length) {
            int len = Math.min(dataBytes.length - idx, chunkSize);
            byte[] encChunk = cipher.doFinal(dataBytes, idx, len);
            buf.put(encChunk);
            idx += len;
        }
        return buf.array();
    }

    private static byte[] decrypt(byte[] dataBytes, Cipher cipher, RSAKey rsaKey) throws Exception {
        int chunkSize = rsaKey.getModulus().bitLength() / 8;
        int idx = 0;
        ByteBuffer buf = ByteBuffer.allocate(dataBytes.length);
        while (idx < dataBytes.length) {
            int len = Math.min(dataBytes.length - idx, chunkSize);
            byte[] chunk = cipher.doFinal(dataBytes, idx, len);
            buf.put(chunk);
            idx += len;
        }
        return buf.array();
    }

    public static String loadKey(String path) throws Exception {
        return KeyStoreUtil.getKey(path);
    }
}
