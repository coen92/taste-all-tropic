package com.coen92.tat.ordermanagementservice.infrastructure.config;

import com.coen92.tat.ordermanagementservice.infrastructure.out.jdbc.CustomerOrderPayloadToStringConverter;
import com.coen92.tat.ordermanagementservice.infrastructure.out.jdbc.StringToCustomerOrderPayloadConverter;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.Clock;
import java.util.List;

@Configuration
public class BeanConfig {
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public PGSimpleDataSource dataSource() {
        return DataSourceBuilder.create().type(PGSimpleDataSource.class)
                .username("user")
                .password("password")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public AbstractJdbcConfiguration jdbcConfiguration() {
        return new JdbcConfiguration();
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(PGSimpleDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Configuration
    static class JdbcConfiguration extends AbstractJdbcConfiguration {
        @Override
        protected List<Converter> userConverters() {
            return List.of(new CustomerOrderPayloadToStringConverter(), new StringToCustomerOrderPayloadConverter());
        }

        @Override
        public JdbcCustomConversions jdbcCustomConversions() {
            return new JdbcCustomConversions(
                    userConverters()
            );
        }
    }
}
