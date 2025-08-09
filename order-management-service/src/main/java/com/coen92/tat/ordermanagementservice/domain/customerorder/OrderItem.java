package com.coen92.tat.ordermanagementservice.domain.customerorder;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
class OrderItem {
    ItemType type;
    ItemId id;

    enum ItemType {
        DRINK
    }
}
