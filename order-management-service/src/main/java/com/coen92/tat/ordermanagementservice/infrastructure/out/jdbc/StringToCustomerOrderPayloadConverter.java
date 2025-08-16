package com.coen92.tat.ordermanagementservice.infrastructure.out.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.coen92.tat.ordermanagementservice.infrastructure.out.CustomerOrdersEntity.CustomerOrderPayload;

@Component
public class StringToCustomerOrderPayloadConverter implements Converter<String, CustomerOrderPayload> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public CustomerOrderPayload convert(String source) {
        return objectMapper.readValue(source, CustomerOrderPayload.class);
    }
}
