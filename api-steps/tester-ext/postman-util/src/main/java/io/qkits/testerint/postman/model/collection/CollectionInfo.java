package io.qkits.testerint.postman.model.collection;

//import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CollectionInfo implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("_postman_id")
    private String postmanId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("schema")
    private String schema;

}
