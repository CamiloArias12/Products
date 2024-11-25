package com.example.products.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.products.model.Product;
import com.example.products.services.OrderService;
import com.example.products.services.ProductService;


@Controller
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;

    private List<Product> selectedProducts = new ArrayList<>();

    public OrderController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String showOrderPage(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("selectedProducts", selectedProducts);
        model.addAttribute("orders", orderService.findAll());
        return "order";
    }

    @PostMapping("/addProducts")
    public String addProducts(@RequestParam("selectedProducts") List<Integer> productIds) {
        productIds.forEach(id -> {
            Product product = productService.find(id);
            if (!selectedProducts.contains(product)) {
                selectedProducts.add(product);
            }
        });
        return "redirect:/";
    }

    @PostMapping("/removeProducts")
    public String removeProducts(@RequestParam("selectedProducts") List<Integer> productIds) {
        selectedProducts.removeIf(product -> productIds.contains(product.getId()));
        return "redirect:/";
    }

    @PostMapping("/generateOrder")
    public String generateOrder() {
        System.out.println("Selected products:");
        System.out.println(selectedProducts);
        orderService.create(new ArrayList<Product>(selectedProducts));
        selectedProducts.clear();
        return "redirect:/";
    }

}
