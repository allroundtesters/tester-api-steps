package io.qkits.common.db;


import io.qkits.common.db.sql.DefaultSQLSourceConnector;

import java.util.Map;


public class DataSourceConnectorFactory {

    public static DataSourceConnector createDataConnector(Map<String,String> configs){
       DataSourceConnector connector = new DefaultSQLSourceConnector();
        connector.init(configs);
        return connector;
    }


    public static DataSourceConnector createLocalDataConnector(){

        DataSourceConnector connector = new DefaultSQLSourceConnector();
        connector.init(DataSourceConfigFactory.localMySQLConfig());
        return connector;
    }


}
