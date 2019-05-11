package io.qkits.testdata.mock.base;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author patrick
 * dataPathMap:
 */
@Data
public abstract class BaseFeatureEntity {

    protected Map<String, FeatureDefinition> dataPathMap = new ConcurrentHashMap<>();
    protected Map<String, Map<Object, Object>> statusMap = new ConcurrentHashMap<>();
    protected Map<String, Object> resultMap = new ConcurrentHashMap<>(6);

    public BaseFeatureEntity(){
        //todo： 黑科技，顺序有关系
        initStatusMap();
        initDataPath();
    }
    protected abstract void initStatusMap(); //copy for existing code
    protected abstract void initDataPath();
}
