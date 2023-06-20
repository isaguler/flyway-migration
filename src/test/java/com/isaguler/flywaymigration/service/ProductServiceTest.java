package com.isaguler.flywaymigration.service;

import com.isaguler.flywaymigration.dto.ProductDTO;
import com.isaguler.flywaymigration.model.Product;
import com.isaguler.flywaymigration.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    private List<Product> products;
    private List<Product> enabledProducts;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(1L, null, "p-1", "d-1", new BigDecimal(10), true);
        Product product2 = new Product(2L, null, "p-2", "d-2", new BigDecimal(20), true);
        Product product3 = new Product(3L, null, "p-3", "d-3", new BigDecimal(30), false);

        products = List.of(product1, product2, product3);
        enabledProducts = List.of(product1, product2);

    }

    @Test
    void shouldReturnAllProductList() {
        List<ProductDTO> expectedDTOs = products.stream()
                .map(ProductDTO::convert)
                .toList();

        when(productRepository.findAll()).thenReturn(products);

        List<ProductDTO> all = productService.getAll();

        assertEquals(expectedDTOs, all);
    }

    @Test
    void shouldReturnOnlyEnabledProductList() {
        List<ProductDTO> expectedDTOs = enabledProducts.stream()
                .map(ProductDTO::convert)
                .toList();

        when(productRepository.findByEnabledTrue()).thenReturn(enabledProducts);

        List<ProductDTO> enabledProduct = productService.getEnabledProduct();

        assertEquals(expectedDTOs, enabledProduct);
    }
}