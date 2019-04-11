package io.qkits.common.db.sql;

import io.qkits.common.db.DataSourceConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

@Slf4j
public class DefaultSQLSourceConnector implements DataSourceConnector {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void init(Map<String, String> configs) {
        log.info("start init database.....");
        this.dataSource = new DriverManagerDataSource();
        dataSource.setUrl(configs.get("url"));
        dataSource.setDriverClassName(configs.get("driverClassName"));
        dataSource.setUsername(configs.get("userName"));
        dataSource.setPassword(configs.get("password"));
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(this.dataSource);
    }

    @Override
    public Map<String, Object> findOne(String query) {
        return findMore(query).get(0);
    }

    @Override
    public List<Map<String, Object>> findMore(String query) {
        return jdbcTemplate.queryForList(query);
    }
}
