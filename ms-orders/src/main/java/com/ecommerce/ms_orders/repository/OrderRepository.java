package com.ecommerce.ms_orders.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.ms_orders.model.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomerContainingIgnoreCase(String customer);
    List<Order> findByStatusIgnoreCase(String status);
}
