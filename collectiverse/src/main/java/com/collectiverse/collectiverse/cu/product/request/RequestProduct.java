package com.collectiverse.collectiverse.cu.product.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/** Datos que envía el cliente en este caso de uso. */
public record RequestProduct(
        @NotNull(message = "La categoría es obligatoria")
        Integer idCategory,
        Integer idCollection, // opcional: un producto puede no pertenecer a una colección
        @NotBlank(message = "El nombre del producto es obligatorio")
        @Size(max = 100, message = "El nombre no puede pasar de 100 caracteres")
        String name,
        @NotNull(message = "El stock es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock,
        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
        BigDecimal price) {
}
