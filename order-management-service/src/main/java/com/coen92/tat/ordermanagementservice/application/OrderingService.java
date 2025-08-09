package com.coen92.tat.ordermanagementservice.application;

import com.coen92.tat.ordermanagementservice.domain.customerorder.CustomerId;
import com.coen92.tat.ordermanagementservice.domain.customerorder.CustomerOrder;
import com.coen92.tat.ordermanagementservice.domain.customerorder.OrderId;
import com.coen92.tat.ordermanagementservice.domain.customerorder.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrderingService implements OrderingFacade {
    private final OrderRepository repository;

    @Override
    public OrderId createOrder(CustomerId customerId) {
        var customerOrder = CustomerOrder.create(customerId);
        repository.save(customerOrder);
        return customerOrder.getOrderId();
    }
}
