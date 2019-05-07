package io.qkits.common.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by patrick on 15/3/13.
 *
 * @version $Id$
 */


@SuppressWarnings("unchecked")
public class JSONUtils {
    private static ObjectMapper mapper = new ObjectMapper();


    public static <T> T fromJson(String json, Class<T> t) {
        if (json == null) {
            return null;
        } else {
            try {
                return mapper.readValue(json, t);
            } catch (Exception var3) {
                throw new RuntimeException("convert fromJson failed: " + json + ", dest class: " + t.getName(), var3);
            }
        }
    }

    public static <T> T toBean(String jsonString, Class beanClz) {
        try {
            return (T) mapper.readValue(jsonString, beanClz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromObject(Object srcObj, Class<T> t) {
        if (srcObj == null) {
            return null;
        } else {
            try {
                return mapper.convertValue(srcObj, t);
            } catch (Exception var3) {
                throw new RuntimeException("convert fromObject failed: " + srcObj + ", dest class: " + t.getName(), var3);
            }
        }
    }

    public static <T> T fromMap(Map<?, ?> map, Class<T> t) {
        if (map == null) {
            return null;
        } else {
            try {
                return mapper.readValue(toJsonString(map), t);
            } catch (Exception var3) {
                throw new RuntimeException("convert fromMap failed: " + map + ", dest class: " + t.getName(), var3);
            }
        }
    }

    public static String toJsonString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception var2) {
            throw new RuntimeException("convert toJsonString failed: " + obj, var2);
        }
    }

    static {
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    private JSONUtils() {
    }

//    public static <T> T toBean(String jsonString, Class<T> clazz) {
//
//        return JSON.parseObject(jsonString, clazz);
//    }

//    /**
//     * parse Json to List
//     *
//     * @param jsonString
//     * @param type
//     * @param <T>
//     * @return
//     */
//    public static <T> List<T> toList(String jsonString, TypeReference type) {
//        return (List<T>) JSON.parseObject(jsonString, type);
//    }
//
//    public static List<Map<String, String>> toMapList(String jsonString) {
//        List<Map<String, String>> result = Lists.newArrayList();
//        try {
//            result = JSONHelper.toList(jsonString.trim(), new TypeReference<List<Map<String, String>>>() {
//            });
//        } catch (Exception e) {
//            throw new RuntimeException("输入数据有错，请检查，需要是[{key:value},{key:value}]格式,此数据格式是:" + jsonString);
//        }
//
//        return result;
//    }


    /*
    {
        "store": {
            "book": [
                {
                    "category": "reference",
                    "author": "Nigel Rees",
                    "title": "Sayings of the Century",
                    "price": 8.95
                },
                {
                    "category": "fiction",
                    "author": "Evelyn Waugh",
                    "title": "Sword of Honour",
                    "price": 12.99
                },
                {
                    "category": "fiction",
                    "author": "Herman Melville",
                    "title": "Moby Dick",
                    "isbn": "0-553-21311-3",
                    "price": 8.99
                },
                {
                    "category": "fiction",
                    "author": "J. R. R. Tolkien",
                    "title": "The Lord of the Rings",
                    "isbn": "0-395-19395-8",
                    "price": 22.99
                }
            ],
            "bicycle": {
                "color": "red",
                "price": 19.95
            }
        },
        "expensive": 10
    }

    JsonPath (click link to try)	Result
        $.store.book[*].author	The authors of all books
        $..author	All authors
        $.store.*	All things, both books and bicycles
        $.store..price	The price of everything
        $..book[2]	The third book
        $..book[(@.length-1)]	The last book
        $..book[0,1]	The first two books
        $..book[:2]	All books from index 0 (inclusive) until index 2 (exclusive)
        $..book[1:2]	All books from index 1 (inclusive) until index 2 (exclusive)
        $..book[-2:]	Last two books
        $..book[2:]	Book number two from tail
        $..book[?(@.isbn)]	All books with an ISBN number
        $.store.book[?(@.price < 10)]	All books in store cheaper than 10
        $..book[?(@.price <= $['expensive'])]	All books in store that are not "expensive"
        $..book[?(@.author =~ /.*REES/i)]	All books matching regex (ignore case)
        $..*	Give me every thing
    */
    public static Object getValue(String jsonString, String jsonPathExpression) {
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);
        //        if(o instanceof JSONArray){
//            if(((JSONArray) o).size()==1){
//                try{
//                return ((JSONArray) o).get(0);
//                }catch (Exception e){
//                    return ((JSONArray) o).get(0).toString();
//                }
////            }else{
////                List<JSONArray> result = Lists.newArrayList();
////                ((JSONArray) o).forEach(element->result.add((JSONArray) element));
////                return result;
//            }
//
//        }
        return JsonPath.read(document, jsonPathExpression);
    }

    public static String flattenJson(String json) throws IOException {
        Map<String, Object> outputMap = new LinkedHashMap<>();
        flattenJsonIntoMap("", mapper.readTree(json), outputMap);
        return mapper.writeValueAsString(outputMap);
    }

    public static void flattenJsonIntoMap(String currentPath, JsonNode jsonNode, Map<String, Object> map) {
        if (jsonNode.isObject()) {
            ObjectNode objectNode = (ObjectNode) jsonNode;
            Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
            String pathPrefix = currentPath.isEmpty() ? "" : currentPath + ".";

            while (iter.hasNext()) {
                Map.Entry<String, JsonNode> entry = iter.next();
                flattenJsonIntoMap(pathPrefix + entry.getKey(), entry.getValue(), map);
            }
        } else if (jsonNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            for (int i = 0; i < arrayNode.size(); i++) {
                flattenJsonIntoMap(currentPath + "[" + i + "]", arrayNode.get(i), map);
            }
        } else if (jsonNode.isValueNode()) {
            ValueNode valueNode = (ValueNode) jsonNode;
            Object value = null;
            if (valueNode.isNumber()) {
                value = valueNode.numberValue();
            } else if (valueNode.isBoolean()) {
                value = valueNode.asBoolean();
            } else if (valueNode.isTextual()) {
                value = valueNode.asText();
            }
            map.put(currentPath, value);
        }
    }
//
//    /**
//     * 获取第一个数组值到Map
//     *
//     * @param jsonString
//     * @param jsonPathExpression
//     * @return
//     */
//    public static Map<String, String> getArrayValueToMap(String jsonString, String jsonPathExpression) {
//
//        try {
//            return (Map<String, String>) ((JSONArray) getValue(jsonString, jsonPathExpression)).get(0);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }


    /**
     * @param jsonString
     * @param jsonPathExpression
     * @return 如果有路径存在在返回实际值, 否则返回空字符串
     */
    public static String getStringValue(String jsonString, String jsonPathExpression) {
        try {
            return JsonPath.read(jsonString, jsonPathExpression).toString();
        } catch (Exception e) {
            return StringsUtils.EMPTY;
        }
    }
}