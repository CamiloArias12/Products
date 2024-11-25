package com.example.products.services.interfaces;

import java.util.List;

import com.example.products.model.Order;

public interface IOrderService  {
    public void create(Integer[] productIds);
    public List<Order> findAll();

}
