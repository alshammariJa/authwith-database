package com.example.final_auth.repository;

import com.example.final_auth.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderById(Integer id);
}
