package com.coen92.tat.ordermanagementservice.domain.customerorder;

import lombok.Getter;

import java.util.List;

// main aggregate for ordering bounded context
@Getter
public class CustomerOrder {
    private final CustomerId customerId;
    private final OrderId orderId;

    // mutable properties
    private OrderStatus status;
    private OrderItems items;
    // price, delivery address, payment method, etc. can be added later

    private CustomerOrder(CustomerId customerId) {
        this.customerId = customerId;
        this.orderId = OrderId.newOrder();
        this.status = OrderStatus.NEW;
        this.items = new OrderItems();
    }

    // factory methods for behavioral scenarios on aggregate
    public static CustomerOrder create(CustomerId customerId) {
        return new CustomerOrder(customerId);
    }


    // methods to expose protected aggregate details
    public List<OrderItem> getOrderItems() {
        return items.items;
    }

    public String getOrderCurrentStatus() {
        return status.name();
    }

    private enum OrderStatus {
        NEW,
        PLACED,
        CANCELLED,
        COMPLETED
    }


    // access to customer order items only through main aggregate
    @Getter
    private static class OrderItems {
        final List<OrderItem> items;

        public OrderItems() {
            this.items = List.of();
        }
    }
}
