package io.qkits.testdata.mock.thirdparty;


import java.util.HashMap;

/**
 * @author patrick
 */
public class TPMockResponse extends HashMap {


    public TPMockResponse() {
    }

    public TPMockResponse addVariable(String key, Object value) {
        this.put(key, value);
        return this;
    }
}
