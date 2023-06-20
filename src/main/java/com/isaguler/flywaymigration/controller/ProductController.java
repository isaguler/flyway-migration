package com.isaguler.flywaymigration.controller;

import com.isaguler.flywaymigration.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping("/product/enabled")
    public ResponseEntity<Object> getAllEnabled() {
        return ResponseEntity.ok().body(productService.getEnabledProduct());
    }
}
