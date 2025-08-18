package com.coen92.tat.ordermanagementservice.infrastructure.config;

import com.coen92.tat.ordermanagementservice.infrastructure.out.jdbc.CustomerOrderPayloadToStringConverter;
import com.coen92.tat.ordermanagementservice.infrastructure.out.jdbc.StringToCustomerOrderPayloadConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.time.Clock;
import java.util.List;

@Configuration
public class BeanConfig {
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public AbstractJdbcConfiguration jdbcConfiguration() {
        return new JdbcConfiguration();
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
