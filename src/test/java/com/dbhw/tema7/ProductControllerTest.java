package com.dbhw.tema7;

import com.dbhw.tema7.controller.ProductController;
import com.dbhw.tema7.model.Product;
import com.dbhw.tema7.model.ProductType;
import com.dbhw.tema7.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_get_all_undeleted_products() throws Exception{
        Product myProduct = new Product(null, ProductType.ELB, "Masina_de_spalat", "ABC123", 100, false, 1700);
        mockMvc.perform(get("/products/all/undeleted")).andExpect(status().isOk());
    }
}
