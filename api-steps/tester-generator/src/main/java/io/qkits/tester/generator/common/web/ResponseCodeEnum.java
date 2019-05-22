package io.qkits.tester.generator.common.web;

/**
 * @author patrick
 */

public enum  ResponseCodeEnum {
    /**
     * success:1
     * fail: 0
     *
     */
    SUCCESS(1),FAIL(0);

    private int code;
    ResponseCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
