package io.qkits.testerint.postman.model.collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CollectionItemEvent implements Serializable {

    @JsonProperty("listen")
    private String listen;

    @JsonProperty("script")
    private CollectionItemEventScript eventScript;

    @Data
    @ToString
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CollectionItemEventScript implements Serializable {

        @JsonProperty("type")
        private String type;

        @JsonProperty("exec")
        private List<String> exec;

        @JsonIgnore
        private Map<String, Object> execStrMap = new HashMap<>();

    }
}
