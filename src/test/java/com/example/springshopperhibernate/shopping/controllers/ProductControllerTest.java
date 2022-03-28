package com.example.springshopperhibernate.shopping.controllers;

import com.example.springshopperhibernate.shopping.models.Product;
import com.example.springshopperhibernate.shopping.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductRepository mockRepository;

    @BeforeEach
    public void init() {

        Product p1 = new Product("1", "docka", 1L);
        Product p2 = new Product("2", "nalle", 2L);
        Product p3 = new Product("3", "byxor", 3L);
        when(mockRepository.findById(1L)).thenReturn(Optional.of(p1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(p1, p2, p3));
    }

    @Test
    void addNew() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product/add?productNumber=4&name=boll")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("boll is Saved")));
    }

    @Test
    void getById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product/getById?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"docka\",\"productnumber\":\"1\"}"));
    }

    @Test
    public void findAllTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"docka\",\"productnumber\":\"1\"}," +
                        "{\"id\":2,\"name\":\"nalle\",\"productnumber\":\"2\"},"+
                        "{\"id\":3,\"name\":\"byxor\",\"productnumber\":\"3\"}]"));
    }

}