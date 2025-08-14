package com.coen92.tat.ordermanagementservice.infrastructure.out;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface OrderJdbcRepository extends ListCrudRepository<CustomerOrdersEntity, UUID> {

}
