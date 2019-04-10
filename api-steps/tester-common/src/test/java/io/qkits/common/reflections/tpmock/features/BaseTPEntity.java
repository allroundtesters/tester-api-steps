package io.qkits.common.reflections.tpmock.features;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public abstract class BaseTPEntity {

    protected Map<String, DataPath> dataPathMap = new ConcurrentHashMap<>();
    protected Map<String, Map<Object, Object>> statusMap = new ConcurrentHashMap<>();

    public BaseTPEntity(){
        initDataPath();
        initStatusMap();
    }
    protected abstract void initStatusMap();
    protected abstract void initDataPath();
}
