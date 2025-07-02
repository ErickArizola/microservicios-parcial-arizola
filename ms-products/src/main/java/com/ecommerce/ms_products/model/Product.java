package com.ecommerce.ms_products.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    @NotBlank(message = "Nombre es requerido")
    private String name;

    private String description;

    @NotNull(message = "Precio es requerido")
    @PositiveOrZero(message = "El precio debe ser 0 o positivo")
    private Double price;

    @NotNull(message = "Stock es requerido")
    @Min(value = 0, message = "El stock debe ser minimo 0")
    private Integer stock;

    private String category;
}
