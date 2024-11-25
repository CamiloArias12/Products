package com.example.products.services.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.example.products.model.Order;
import com.example.products.model.Product;

public interface IOrderService  {
    public void create(ArrayList<Product> products);
    public List<Order> findAll();
}
