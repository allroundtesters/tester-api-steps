package io.qkits.common.db;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverClassMapping {

    public static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";

    public static Map<String, String> SQL_TYPE_DRIVER_MAPPING = new ConcurrentHashMap<String, String>();

    static {
        SQL_TYPE_DRIVER_MAPPING.put(DataType.MYSQL.name().toUpperCase(), MYSQL_DRIVER_CLASS);
        SQL_TYPE_DRIVER_MAPPING.put(DataType.TIDB.name().toUpperCase(), MYSQL_DRIVER_CLASS);
    }

    public static String getDriverClassByType(String type) {

        if (SQL_TYPE_DRIVER_MAPPING.get(type.toUpperCase()) == null)
            throw new ConnectorException("there is no database drive class mapped");
        return MYSQL_DRIVER_CLASS;
    }
}
