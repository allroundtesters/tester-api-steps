package io.qkits.common.db;

import java.util.List;
import java.util.Map;

public interface DataSourceConnector {

    public void init(Map<String, String> configs);

    public Map<String,Object> findOne(String query);
    public List<Map<String,Object>> findMore(String query);
    //TODO:add get config map method
}
