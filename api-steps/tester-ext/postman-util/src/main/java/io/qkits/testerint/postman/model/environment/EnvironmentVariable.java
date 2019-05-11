package io.qkits.testerint.postman.model.environment;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.qkits.testerint.postman.model.Variable;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EnvironmentVariable extends Variable {

    @Override
    public String toString() {
        return "EnvironmentVariable{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                '}';
    }
}
