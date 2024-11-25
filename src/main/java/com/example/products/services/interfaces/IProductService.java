package com.example.products.services.interfaces;

import java.util.List;

import com.example.products.model.Product;

public interface IProductService  {
    public Product find(Integer id);
    public List<Product> findAll();
}
