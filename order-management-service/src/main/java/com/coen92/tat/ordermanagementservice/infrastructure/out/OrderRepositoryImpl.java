package com.coen92.tat.ordermanagementservice.infrastructure.out;

import com.coen92.tat.ordermanagementservice.domain.customerorder.CustomerOrder;
import com.coen92.tat.ordermanagementservice.domain.customerorder.OrderId;
import com.coen92.tat.ordermanagementservice.domain.customerorder.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    // temporary in-memory storage (later full database connection introduced)
    private Map<OrderId, CustomerOrder> orders = new HashMap<>();

    @Override
    public void save(CustomerOrder order) {
        orders.put(order.getOrderId(), order);
    }
}
