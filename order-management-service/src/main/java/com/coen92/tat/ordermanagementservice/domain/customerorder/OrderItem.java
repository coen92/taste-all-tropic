package com.coen92.tat.ordermanagementservice.domain.customerorder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class OrderItem {
    private ItemType type;
    private ItemId id;
    // Quantity quantity, etc.;

    public enum ItemType {
        DRINK
    }
}
