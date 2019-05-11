package io.qkits.testdata.mock.thirdparty;

import java.util.HashMap;

/**
 * @author patrick
 */
public class TPMockRequest extends HashMap {

    public TPMockRequest(){

    }

    public TPMockRequest addVariable(String key,Object value){
        this.put(key,value);
        return this;
    }
}
