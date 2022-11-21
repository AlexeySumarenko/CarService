package org.CarService.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}

