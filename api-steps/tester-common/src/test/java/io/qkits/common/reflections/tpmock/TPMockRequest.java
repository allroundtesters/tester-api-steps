package io.qkits.common.reflections.tpmock;

import java.util.HashMap;

public class TPMockRequest extends HashMap {

    public TPMockRequest(){
        super();
        this.put("department","");
        this.put("serviceName","");
        this.put("idNumbers","");
    }

    public TPMockRequest addVariable(String key,Object value){
        this.put(key,value);
        return this;
    }
}
