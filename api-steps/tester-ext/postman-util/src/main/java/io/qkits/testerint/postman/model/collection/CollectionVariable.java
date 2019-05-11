package io.qkits.testerint.postman.model.collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.qkits.testerint.postman.model.Variable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CollectionVariable extends Variable {

    @Override
    public String toString() {
        return "CollectionVariable{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                '}';
    }
}
