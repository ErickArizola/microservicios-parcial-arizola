package com.idat.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Se requiere nombre")
    private String name;

    @NotBlank(message = "Se requiere descripcion")
    private String description;

    @NotNull(message = "Se requiere precio")
    private Double price;

    @NotNull(message = "Se requiere stock")
    private Integer stock;

    @NotBlank(message = "Se requiere categoria")
    private String category;
}
