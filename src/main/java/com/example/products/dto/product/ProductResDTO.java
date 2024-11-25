package com.example.products.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import com.example.products.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResDTO {
    private int id;
    public String name;
    public String description;
    public String price;
    public int currentStock;

    public static ProductResDTO fromEntity(Product product) {
        return new ProductResDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCurrentStock());
    }

    public static List<ProductResDTO> fromEntities(List<Product> products) {
        List<ProductResDTO> productsRes = new ArrayList<>();
        for (Product product : products) {
            productsRes.add(fromEntity(product));
        }
        return productsRes;
    }
}