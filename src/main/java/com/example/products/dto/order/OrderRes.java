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
public class OrderRes {
    private int id;
    public Product product;

    public static OrderRes fromEntity(Order order) {
        return new OrderRes(
                order.getId(),
                order.getProduct()
                );
    }

    public static List<OrderRes> fromEntities(List<Order> orders) {
        List<OrderRes> ordersRes = new ArrayList<>();
        for (Order order : orders) {
            ordersRes.add(fromEntity(order));
        }
        return ordersRes;
    }
}