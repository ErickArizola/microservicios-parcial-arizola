package com.idat.orders.service;

import com.idat.orders.model.*;
import com.idat.orders.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order create(Order order) {
        order.setDate(LocalDateTime.now());

        // Enlazar cada producto con la orden antes de guardar
        for (OrderItem item : order.getProducts()) {
            item.setOrder(order);
        }

        double total = order.getProducts().stream()
            .mapToDouble(p -> p.getQuantity() * getProductPrice(p.getProductId()))
            .sum();
        order.setTotal(total);

        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public List<Order> findByCustomer(String customer) {
        return orderRepository.findByCustomerContainingIgnoreCase(customer);
    }

    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatusIgnoreCase(status);
    }

    // Simulación de precio (esto se integrará con Circuit Breaker luego)
    public double getProductPrice(Long productId) {
        return 10.0;
    }
}
