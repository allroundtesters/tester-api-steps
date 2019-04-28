package io.qkits.rule.common.db;

import org.springframework.beans.factory.annotation.Value;
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

    @Value(value = "${risk.dbUrl}")
    private String riskDBUrl;
    @Value(value = "${risk.user}")
    private String user;
    @Value(value = "${risk.password}")
    private String password;

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

        dataSource.setUrl(this.riskDBUrl);

        dataSource.setUsername(this.user);
        dataSource.setPassword(this.password);

        return dataSource;
    }

}
