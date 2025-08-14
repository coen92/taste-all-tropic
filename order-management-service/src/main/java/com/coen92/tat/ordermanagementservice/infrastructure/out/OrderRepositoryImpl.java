package com.coen92.tat.ordermanagementservice.infrastructure.out;

import com.coen92.tat.ordermanagementservice.domain.customerorder.CustomerOrder;
import com.coen92.tat.ordermanagementservice.domain.customerorder.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Clock;
import java.util.List;

import static com.coen92.tat.ordermanagementservice.infrastructure.out.CustomerOrdersEntity.*;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJdbcRepository repository;
    private final Clock clock;

    @Override
    public void save(CustomerOrder order) {
        repository.save(toEntity(order));
    }

    private CustomerOrdersEntity toEntity(CustomerOrder order) {
        OrderEntity customerOrder = new OrderEntity(order.getOrderId().getValue(),
                order.getOrderItems().stream()
                        .map(item -> new ItemEntity(item.getId().getValue(), item.getType().name()))
                        .toList(),
                order.getOrderCurrentStatus()
        );

        return builder()
                .customerId(order.getCustomerId().getValue())
                .createdAt(Timestamp.from(clock.instant()))
                .updatedAt(Timestamp.from(clock.instant()))
                .version(0)
                .payload(CustomerOrderPayload.builder()
                        .orders(List.of(customerOrder))
                        .build())
                .build();
    }
}
