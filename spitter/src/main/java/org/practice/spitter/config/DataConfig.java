package org.practice.spitter.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataConfig {

    @Value("${server.name:defServerName}")
    private String serverName;

    @Value("${db.name:defDbName}")
    private String dbName;

    @Value("${db.port:defDbPort}")
    private int port;

    @Value("${db.user:defDbUser}")
    private String user;

    @Value("${db.pass:defDbPass}")
    private String pass;

    @Bean
    DataSource dataSource() {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName(serverName);
        ds.setDatabaseName(dbName);
        ds.setPortNumber(port);
        ds.setUser(user);
        ds.setPassword(pass);
        return ds;
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
