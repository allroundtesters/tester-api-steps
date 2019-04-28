package io.qkits.rule.common.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyStoreUtil {
    private static Map<String, String> keyMap = new ConcurrentHashMap<>();

    public static String getKey(String path) throws Exception {
        String key = keyMap.get(path);
        if (StringUtils.isNotEmpty(key)) {
            return key;
        }
        key = loadKey(path);
        keyMap.put(path, key);
        return key;
    }

    private static String loadKey(String path) throws Exception {
        BufferedReader reader = null;
        try {
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(path);
            reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

}
