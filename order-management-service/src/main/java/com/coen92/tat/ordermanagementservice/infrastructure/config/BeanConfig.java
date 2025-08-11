package com.coen92.tat.ordermanagementservice.infrastructure.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class BeanConfig {
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public PGSimpleDataSource dataSource() {
        return DataSourceBuilder.create().type(PGSimpleDataSource.class).build();
    }
}
