package io.qkits.testerint.postman.model.global;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.qkits.testerint.postman.model.Variable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GlobalVariable extends Variable {

    @Override
    public String toString() {
        return "GlobalVariable{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                '}';
    }
}
