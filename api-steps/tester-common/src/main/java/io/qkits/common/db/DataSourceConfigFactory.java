package io.qkits.common.db;


import java.util.HashMap;
import java.util.Map;

public class DataSourceConfigFactory {

    public Map<String, String> dataSourceConfig(String dbType,
                                         Map<String, String> origConfig) {

        String driverClass = DriverClassMapping.getDriverClassByType(dbType);
        origConfig.put("driverClassName", driverClass);
        return origConfig;
    }

    public static Map<String,String> localMySQLConfig() {
        DataSourceConfigFactory factory = new DataSourceConfigFactory();
        Map<String,String> configMap = new HashMap<String, String>();
        configMap.put("userName","dq");
        configMap.put("password","dq123456");
        configMap.put("url","jdbc:mysql://localhost:3306");
        return factory.dataSourceConfig(
                DataType.MYSQL.name(),configMap);
    }
}
