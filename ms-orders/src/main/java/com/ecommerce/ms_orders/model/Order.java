package com.ecommerce.ms_orders.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    @NotBlank(message = "Customer is required")
    private String customer;

    private LocalDateTime date;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Products list is required")
    private List<OrderItem> products;

    private Double total;
}
