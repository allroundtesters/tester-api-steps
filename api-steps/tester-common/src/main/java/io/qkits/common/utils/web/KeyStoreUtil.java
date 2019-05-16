//package io.qkits.common.utils.web;
//
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @author patrick
// */
//public class KeyStoreUtil {
//    private static Map<String, String> keyMap = new ConcurrentHashMap<>();
//
//    public static String getKey(String extractPath) throws Exception {
//        String key = keyMap.get(extractPath);
//        if (StringUtils.isNotEmpty(key)) {
//            return key;
//        }
//        key = loadKey(extractPath);
//        keyMap.put(extractPath, key);
//        return key;
//    }
//
//    private static String loadKey(String extractPath) throws Exception {
//        BufferedReader reader = null;
//        try {
//            ResourceLoader resourceLoader = new DefaultResourceLoader();
//            Resource resource = resourceLoader.getResource(extractPath);
//            reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
//            StringBuffer buffer = new StringBuffer();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                buffer.append(line);
//            }
//            return buffer.toString();
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }
//    }
//
//}
