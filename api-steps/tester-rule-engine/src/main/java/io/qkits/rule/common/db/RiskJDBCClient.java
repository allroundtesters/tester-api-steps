package io.qkits.rule.common.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Simple JDBC Client
 */
@Component
public class RiskJDBCClient {

    private JdbcTemplate riskJdbcTemplate;

    @PostConstruct
    public void setupRiskDBTemplate() {
        riskJdbcTemplate = new JdbcTemplate(getDataSource());
    }

    public Map<String, Object> findOne(String query) {
        return findMore(query).get(0);
    }

    public List<Map<String, Object>> findMore(String query) {
        return riskJdbcTemplate.queryForList(query);
    }

    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://test.wr.mysql.bkjk.cn:3309/cred_r_operating?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false");

        dataSource.setUsername("cred_r_operating");
        dataSource.setPassword("iytPU_CJzPUe");

        return dataSource;
    }

}
