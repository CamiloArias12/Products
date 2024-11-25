package com.example.products.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}