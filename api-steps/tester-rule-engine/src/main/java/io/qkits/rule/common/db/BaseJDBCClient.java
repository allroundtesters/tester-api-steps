package io.qkits.rule.common.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Simple JDBC Client
 */
@Component
public class BaseJDBCClient {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> findOne(String query) {
        return findMore(query).get(0);
    }

    public List<Map<String, Object>> findMore(String query) {
        return jdbcTemplate.queryForList(query);
    }

}
