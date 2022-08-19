package com.dbhw.tema7;

import com.dbhw.tema7.controller.ShoppingCartController;
import com.dbhw.tema7.service.ProductService;
import com.dbhw.tema7.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductService.class)
public class ProductServiceTest {
    @MockBean
    ProductService ProductService;

    @Autowired
    private MockMvc mockMvc;
}
