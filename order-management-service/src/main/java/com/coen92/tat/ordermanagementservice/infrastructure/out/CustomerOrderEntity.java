package com.coen92.tat.ordermanagementservice.infrastructure.out;

import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.sql.Timestamp;
import java.util.UUID;

@Builder(access = AccessLevel.PACKAGE)
public class CustomerOrderEntity {
    @Id
    private UUID orderId;

    @CreatedDate
    private Timestamp createdAt;
    @LastModifiedDate
    private Timestamp updatedAt;
    @Version
    private Integer version;

    private CustomerOrderPayload payload;

    record CustomerOrderPayload(
            // todo: fill with actual fields
    ) {
    }
}
