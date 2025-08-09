package com.coen92.tat.ordermanagementservice.domain.customerorder;

import com.coen92.tat.ordermanagementservice.domain.ValueObject;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public class CustomerId extends ValueObject<UUID> {
    protected CustomerId(UUID value) {
        super(value);
    }

    public static CustomerId of(UUID customerId) {
        return new CustomerId(customerId);
    }
}
