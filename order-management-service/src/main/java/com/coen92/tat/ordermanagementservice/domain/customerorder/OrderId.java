package com.coen92.tat.ordermanagementservice.domain.customerorder;

import com.coen92.tat.ordermanagementservice.domain.ValueObject;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public class OrderId extends ValueObject<UUID> {
    protected OrderId(UUID value) {
        super(value);
    }

    public static OrderId newOrder() {
        return new OrderId(UUID.randomUUID());
    }
}
