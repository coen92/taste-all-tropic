package com.coen92.tat.ordermanagementservice.infrastructure.out.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.coen92.tat.ordermanagementservice.infrastructure.out.CustomerOrdersEntity.CustomerOrderPayload;

@Component
public class CustomerOrderPayloadToStringConverter implements Converter<CustomerOrderPayload, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public String convert(CustomerOrderPayload source) {
        return objectMapper.writeValueAsString(source);
    }
}
