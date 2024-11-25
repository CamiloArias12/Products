package com.example.products.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.products.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

     @Query("SELECT COALESCE(MAX(o.id), 0) FROM Order o")
    Integer findLastOrderId();
}