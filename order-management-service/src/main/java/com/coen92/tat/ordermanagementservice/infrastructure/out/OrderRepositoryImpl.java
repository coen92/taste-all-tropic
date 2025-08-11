package com.coen92.tat.ordermanagementservice.infrastructure.out;

import com.coen92.tat.ordermanagementservice.domain.customerorder.CustomerOrder;
import com.coen92.tat.ordermanagementservice.domain.customerorder.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Clock;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJdbcRepository repository;
    private final Clock clock;

    @Override
    public void save(CustomerOrder order) {
        repository.save(toEntity(order));
    }

    private CustomerOrderEntity toEntity(CustomerOrder order) {
        return CustomerOrderEntity.builder()
                .orderId(order.getOrderId().getValue())
                .createdAt(Timestamp.from(clock.instant()))
                .updatedAt(Timestamp.from(clock.instant()))
                .version(0)
                .payload(new CustomerOrderEntity.CustomerOrderPayload(
                        // todo: fill with actual fields
                ))
                .build();
    }
}
