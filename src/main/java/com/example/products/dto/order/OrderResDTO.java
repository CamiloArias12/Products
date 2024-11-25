package com.example.products.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import com.example.products.model.Order;
import com.example.products.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResDTO {
    private int id;
    public Product product;

    public static OrderResDTO fromEntity(Order order) {
        return new OrderResDTO(
                order.getId(),
                order.getProduct()
                );
    }

    public static List<OrderResDTO> fromEntities(List<Order> orders) {
        List<OrderResDTO> ordersRes = new ArrayList<>();
        for (Order order : orders) {
            ordersRes.add(fromEntity(order));
        }
        return ordersRes;
    }
}