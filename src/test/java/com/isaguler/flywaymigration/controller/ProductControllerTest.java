package com.isaguler.flywaymigration.controller;

import com.isaguler.flywaymigration.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllProductList() throws Exception {
        BDDMockito.given(productService.getAll()).willReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders.get("/product"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void getAllEnabled() throws Exception {
        BDDMockito.given(productService.getEnabledProduct()).willReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders.get("/product/enabled"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}