package io.qkits.testerint.postman.model.collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CollectionItem implements Serializable {

    @JsonIgnore
    public static final String KEY = "key";

    @JsonIgnore
    public static final String VALUE = "value";

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("item")
    private List<CollectionItemDetail> item = new ArrayList<>();


    @Data
    @ToString
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CollectionItemDetail implements Serializable {

        @JsonProperty("name")
        private String name;

        @JsonProperty("event")
        private List<CollectionItemEvent> events = new ArrayList<>();

        @JsonProperty("request")
        private CollectionItemRequest request;

        @JsonProperty("response")
        private List<String> response;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<CollectionItemEvent> getEvents() {
            return events;
        }

        public void setEvents(List<CollectionItemEvent> events) {
            this.events = events;
        }

        public CollectionItemRequest getRequest() {
            return request;
        }

        public void setRequest(CollectionItemRequest request) {
            this.request = request;
        }

        public List<String> getResponse() {
            return response;
        }

        public void setResponse(List<String> response) {
            this.response = response;
        }

    }
}
