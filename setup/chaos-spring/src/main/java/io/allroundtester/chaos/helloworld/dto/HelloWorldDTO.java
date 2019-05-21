package io.allroundtester.chaos.helloworld.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author patrick
 */
@Data
@Builder
public class HelloWorldDTO {
    private long id;
    private String msg;
}
