package com.ecommerce.ms_orders.controller;
import com.ecommerce.ms_orders.model.Order;
import com.ecommerce.ms_orders.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@Valid @RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Order>> getByCustomer(@RequestParam String name) {
        return ResponseEntity.ok(orderService.findByCustomer(name));
    }

    @GetMapping("/status")
    public ResponseEntity<List<Order>> getByStatus(@RequestParam String status) {
        return ResponseEntity.ok(orderService.findByStatus(status));
    }
}
