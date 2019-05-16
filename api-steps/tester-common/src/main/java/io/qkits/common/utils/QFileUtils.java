package io.qkits.common.utils;

import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author patrick
 * @date created on 2019-05-07
 **/
@Slf4j
public class QFileUtils extends FileUtil {

    private static final String classPath = getClassPath();
    public static final String separatorChar = File.separatorChar == '\\' ? "\\\\" : File.separator;
    private static final String SOURCE_BASE_PATH = classPath.replaceAll("target/classes/", "")
            .replaceAll("target/test-classes/", "");

    private QFileUtils() {
    }

    private static String getClassPath() {
        try {
            return java.net.URLDecoder.decode(QFileUtils.class.getClassLoader().getResource("").getPath(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("error+{}", e);
        }

        throw new RuntimeException("可能你使用了中文名字作为了项目名称,或者在你的路径中");
    }

    public static String getTestSrcPath() {
        return SOURCE_BASE_PATH + File.separator + "src/test/java/";
    }

    public static String getSrcPath() {
        return SOURCE_BASE_PATH + "src/main/java/";
    }

    public static String getResourcePath() {
        return SOURCE_BASE_PATH + "src/main/resources/";
    }

    public static String getDirPathInResourcePath(String resourcePath) {
        return SOURCE_BASE_PATH + "src/main/resources/" + resourcePath;
    }

    public static String getTestResourcePath() {
        return SOURCE_BASE_PATH + "src/test/resources/";
    }

    public static String getDirPathInTestResource(String resourcePath) {
        return SOURCE_BASE_PATH + "src/test/resources/" + resourcePath;
    }

    /**
     * package转换为路径格式
     */
    public static String packageToDir(String packageName) {
        String[] array = packageName.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String str : array) {
            sb.append(str).append(File.separator);
        }
        return sb.toString();
    }

    public static Map<String, List<String>> getResourceDirFileMap(String dirPath) {
        // {dir_name, list<file_name>}
        Map<String, List<String>> maps = Maps.newHashMap();
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files == null) {
                throw new RuntimeException("输入路径错误，请检查输入路径");
            }
            for (File f : files) {
                if (f.isDirectory()) {
                    if (maps.get(dir.getName()) == null) {
                        maps.putAll(getResourceDirFileMap(dirPath + "/" + f.getName()));
                    } else {
                        maps.get(dir.getName()).addAll(
                                getResourceDirFileMap(dirPath + "/" + f.getName()).get(dirPath));
                    }
                } else {
                    if (maps.get(dir.getName()) == null) {
                        maps.put(dir.getName(), Lists.newArrayList(f.getName()));
                    } else {
                        maps.get(dir.getName()).add(f.getName());
                    }
                }
            }
        }
        return maps;
    }


    /**
     * 是否存在于classPath
     *
     * @param fileName
     * @return
     */
    public static boolean existsInClasspath(final String fileName) {
        return getResourceFromClasspath(fileName) != null;
    }

    /**
     * 获取文件的URL,包括从Jar包中获取
     *
     * @param fileName
     * @return
     */
    public static URL getResourceFromClasspath(final String fileName) {

        return ClassLoader.getSystemClassLoader().getResource(fileName);
    }

}
