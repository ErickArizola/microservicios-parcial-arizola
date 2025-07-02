package com.ecommerce.ms_orders.service;

import com.ecommerce.ms_orders.model.Order;
import com.ecommerce.ms_orders.repository.OrderRepository;
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

        double total = order.getProducts().stream()
            .mapToDouble(p -> p.getQuantity() * getProductPrice(p.getProductId()))
            .sum();
        order.setTotal(total);

        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(String id) {
        return orderRepository.findById(id)
            .orElseThrow();
    }

    public List<Order> findByCustomer(String customer) {
        return orderRepository.findByCustomerContainingIgnoreCase(customer);
    }

    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatusIgnoreCase(status);
    }

    // Simulación de precio base
    private double getProductPrice(Long productId) {
        return 10.0; // Fijo por ahora
    }
}
