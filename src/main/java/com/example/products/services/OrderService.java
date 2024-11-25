package com.example.products.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.model.Order;
import com.example.products.model.Product;
import com.example.products.repository.OrderRepository;
import com.example.products.services.interfaces.IOrderService;


@Service
public class OrderService implements IOrderService {
       private final OrderRepository orderRepository;
       private final ProductService productService;


    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    public void create(Integer[] productIds) {
        Order order = new Order();

        for (Integer productId : productIds) {
            Product product=productService.find(productId);
            order.setProduct(product);
            orderRepository.save(order);
        }
    }
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}

