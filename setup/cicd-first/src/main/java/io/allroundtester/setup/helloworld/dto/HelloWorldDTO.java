package io.allroundtester.setup.helloworld.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloWorldDTO {
    private long id;
    private String msg;
}
