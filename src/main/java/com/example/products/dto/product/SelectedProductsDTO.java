package com.example.products.dto.product;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class SelectedProductsDTO {

    @NotEmpty(message = "Debe seleccionar al menos un producto")
    private List<Integer> selectedProducts;

    public List<Integer> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Integer> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }
}

