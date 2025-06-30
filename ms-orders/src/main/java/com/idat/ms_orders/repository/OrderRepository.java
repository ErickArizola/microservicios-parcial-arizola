package com.idat.orders.repository;

import com.idat.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerContainingIgnoreCase(String customer);
    List<Order> findByStatusIgnoreCase(String status);
}
