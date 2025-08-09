package com.coen92.tat.ordermanagementservice.application;

import com.coen92.tat.ordermanagementservice.domain.customerorder.CustomerId;
import com.coen92.tat.ordermanagementservice.domain.customerorder.OrderId;

public interface OrderingFacade {
    OrderId createOrder(CustomerId customerId);
}
