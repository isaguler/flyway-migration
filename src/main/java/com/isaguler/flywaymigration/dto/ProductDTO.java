package com.isaguler.flywaymigration.dto;

import com.isaguler.flywaymigration.model.Product;

import java.math.BigDecimal;

public record ProductDTO(Long id, String name, String description, BigDecimal price) {

    public static ProductDTO convert(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
