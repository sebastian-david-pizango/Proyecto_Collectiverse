package com.collectiverse.collectiverse.cu.product.response;

import java.math.BigDecimal;

/** Datos que se devuelven al cliente (nunca se expone la entidad completa). */
public record ResponseProduct(Integer id, Integer idCategory, Integer idCollection, String name,
        Integer stock, BigDecimal price, Boolean status) {
}
