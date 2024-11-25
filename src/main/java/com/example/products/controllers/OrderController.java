package com.example.products.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.products.dto.order.OrderResDTO;
import com.example.products.dto.product.ProductResDTO;
import com.example.products.dto.product.SelectedProductsDTO;
import com.example.products.model.Product;
import com.example.products.services.OrderService;
import com.example.products.services.ProductService;
import jakarta.validation.Valid;

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
        List<Product> availableProducts = productService.findAll();
        availableProducts.removeAll(selectedProducts);
        model.addAttribute("products",ProductResDTO.fromEntities(availableProducts) );
        model.addAttribute("selectedProducts",ProductResDTO.fromEntities(selectedProducts));
        model.addAttribute("orders", OrderResDTO.fromEntities(orderService.findAll()));

        return "order";
    }

    @PostMapping("/addProducts")
    public String addProducts(@ModelAttribute @Valid SelectedProductsDTO dto, BindingResult result,Model model) {
        if (result.hasErrors()) {
            List<Product> availableProducts = productService.findAll();
            availableProducts.removeAll(selectedProducts);
            model.addAttribute("products",ProductResDTO.fromEntities(availableProducts) );
            model.addAttribute("selectedProducts",ProductResDTO.fromEntities(selectedProducts));
            model.addAttribute("orders", OrderResDTO.fromEntities(orderService.findAll()));
            model.addAttribute("error", "You must select at least one product");
            return "order"; 
        }

        dto.getSelectedProducts().forEach(id -> {
            Product product = productService.find(id);
            if (product != null && !selectedProducts.contains(product)) {
                selectedProducts.add(product);
            }
        });

        return "redirect:/";
    }

    @PostMapping("/removeProducts")
    public String removeProducts(@ModelAttribute @Valid SelectedProductsDTO dto, BindingResult result,Model model) {
        if (result.hasErrors()) {
            List<Product> availableProducts = productService.findAll();
            availableProducts.removeAll(selectedProducts);
            model.addAttribute("products",ProductResDTO.fromEntities(availableProducts) );
            model.addAttribute("selectedProducts",ProductResDTO.fromEntities(selectedProducts));
            model.addAttribute("orders", OrderResDTO.fromEntities(orderService.findAll()));
            model.addAttribute("error", "You must select at least one product");
            return "order"; 
        }
        selectedProducts.removeIf(product -> dto.getSelectedProducts().contains(product.getId()));

        return "redirect:/";
    }

    @PostMapping("/generateOrder")
    public String generateOrder(Model model) {
        if (selectedProducts.size()==0) {
            List<Product> availableProducts = productService.findAll();
            availableProducts.removeAll(selectedProducts);
            model.addAttribute("products",ProductResDTO.fromEntities(availableProducts) );
            model.addAttribute("selectedProducts",ProductResDTO.fromEntities(selectedProducts));
            model.addAttribute("orders", OrderResDTO.fromEntities(orderService.findAll()));
            model.addAttribute("error", "You must select at least one product");
            return "order"; 
        }
        orderService.create(new ArrayList<Product>(selectedProducts));
        selectedProducts.clear();
        return "redirect:/";
    }

}
