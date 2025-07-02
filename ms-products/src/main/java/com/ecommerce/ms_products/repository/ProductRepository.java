package com.ecommerce.ms_products.repository;

import com.ecommerce.ms_products.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    // Búsqueda por nombre parcial 
    List<Product> findByNameContainingIgnoreCase(String name);
}
