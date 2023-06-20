package com.isaguler.flywaymigration.repository;

import com.isaguler.flywaymigration.model.Product;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldFindEnabledProducts() {
        /*entityManager.persist(new Product(null, new Date(), "p-1", "d-1", BigDecimal.TEN, true));
        entityManager.persist(new Product(null, new Date(), "p-2", "d-2", BigDecimal.TEN, false));*/

        List<Product> enabledList = productRepository.findByEnabledTrue();

        assertThat(enabledList).hasSize(2);
    }
}