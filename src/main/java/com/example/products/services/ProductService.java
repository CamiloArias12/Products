package com.example.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;

@Service
public class ProductService  {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product find(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
  
}

