package com.coen92.tat.ordermanagementservice.domain.customerorder;


public interface OrderRepository {
    void save(CustomerOrder order);
}
