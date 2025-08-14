package com.coen92.tat.ordermanagementservice.infrastructure.out;

import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Builder(access = AccessLevel.PACKAGE)
class CustomerOrdersEntity {
    @Id
    private UUID customerId;

    @CreatedDate
    private Timestamp createdAt;
    @LastModifiedDate
    private Timestamp updatedAt;
    @Version
    private Integer version;

    private CustomerOrderPayload payload;

    @Builder(access = AccessLevel.PACKAGE, toBuilder = true)
    record CustomerOrderPayload(
            List<OrderEntity> orders
    ) {
    }

    @Builder(access = AccessLevel.PACKAGE, toBuilder = true)
    record OrderEntity(
            UUID orderId,
            List<ItemEntity> items,
            String status
    ) {
    }

    @Builder(access = AccessLevel.PACKAGE, toBuilder = true)
    record ItemEntity(
            UUID itemId,
            String itemType
    ) {
    }
}
