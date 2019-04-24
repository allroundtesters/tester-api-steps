
package io.qkits.rule.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class JsonUtils {

    private static ObjectMapper mapper=new ObjectMapper();


    public static String toJsonString(Object object) {

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static <T> T toBean(String jsonString,Class beanClz){
        try {
            return (T) mapper.readValue(jsonString,beanClz);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    public static <T> Map toMap(T instance){
        String result = toJsonString(instance);
        return toBean(result,Map.class);
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
}
