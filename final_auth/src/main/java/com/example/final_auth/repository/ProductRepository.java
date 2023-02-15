package com.example.final_auth.repository;

import com.example.final_auth.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductById(Integer id);
}
