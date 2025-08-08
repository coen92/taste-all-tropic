package com.coen92.tat.ordermanagementservice.domain.customerorder;

import com.coen92.tat.ordermanagementservice.domain.ValueObject;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
class ItemId extends ValueObject<UUID> {
    protected ItemId(UUID value) {
        super(value);
    }
}
