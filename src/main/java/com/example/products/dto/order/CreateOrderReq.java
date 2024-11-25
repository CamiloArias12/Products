package com.example.products.dto.order;

import java.io.Serializable;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class CreateOrderReq implements Serializable {

    @NotNull(message = "The products array cannot be null")
    @NotEmpty(message = "There must be at least one product in the order")
    @Size(min = 1, message = "The order must contain at least one product")
    private int[] products;

}

