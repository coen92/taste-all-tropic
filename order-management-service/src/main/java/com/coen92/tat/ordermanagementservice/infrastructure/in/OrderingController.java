package com.coen92.tat.ordermanagementservice.infrastructure.in;

import com.coen92.tat.ordermanagementservice.application.OrderingFacade;
import com.coen92.tat.ordermanagementservice.domain.customerorder.CustomerId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderingController {
    private final OrderingFacade facade;

    /**
     * Creates a new customer order for the specified customer.
     *
     * @param body the request body containing the customer ID
     * @return a response entity containing the order ID of the newly created order
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderCreationResponse> createOrder(@RequestBody OrderCreationRequest body) {
        var orderId = facade.createOrder(CustomerId.of(body.customerId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new OrderCreationResponse(orderId.getValue()));
    }

    public record OrderCreationResponse(UUID orderId) {
    }

    public record OrderCreationRequest(UUID customerId) {

    }
}
