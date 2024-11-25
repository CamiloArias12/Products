package com.example.products.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.model.Order;
import com.example.products.model.Product;
import com.example.products.repository.OrderRepository;
import com.example.products.services.interfaces.IOrderService;


@Service
public class OrderService implements IOrderService {
       private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(ArrayList<Product> products) {
        Order order = new Order();        
        Integer lastId = orderRepository.findLastOrderId();
        Integer newId = lastId + 1;
        order.setId(newId);
        for (Product product : products) {
            order.setProduct(product);
            orderRepository.save(order);
        }
    }
    
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}

