package io.qkits.common.db;

public enum DataType {
    /**
     * There are three data source type which we support now.
     */
    HIVE,
    KAFKA,
    AVRO,
    CUSTOM,
    //self-defined
    TIDB,
    MYSQL
}