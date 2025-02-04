package com.example.products.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class OrderPk implements Serializable {
      private Integer id;
      private Product product;

      @Override
      public boolean equals(Object o) {
            if (this == o)
                  return true;
            if (o == null || getClass() != o.getClass())
                  return false;
            OrderPk orderPk = (OrderPk) o;
            return Objects.equals(id, orderPk.id) &&
                        Objects.equals(product, orderPk.product);
                        
      }

      @Override
      public int hashCode() {
            return Objects.hash(id, product);
      }
}
