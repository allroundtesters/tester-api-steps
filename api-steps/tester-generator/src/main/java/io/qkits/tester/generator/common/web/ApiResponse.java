package io.qkits.tester.generator.common.web;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author patrick
 * @date created on 2019-05-20
 **/
@Data
@Builder
public class ApiResponse implements Serializable {

    private int code;
    private String msg;
    private String data;
}
