package com.isaguler.flywaymigration.service;

import com.isaguler.flywaymigration.dto.ProductDTO;
import com.isaguler.flywaymigration.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(ProductDTO::convert).toList();
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getEnabledProduct() {
        return productRepository.findByEnabledTrue().stream().map(ProductDTO::convert).toList();
    }
}
