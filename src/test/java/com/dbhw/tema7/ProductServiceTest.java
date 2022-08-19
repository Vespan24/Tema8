package com.dbhw.tema7;

import com.dbhw.tema7.controller.ShoppingCartController;
import com.dbhw.tema7.model.Product;
import com.dbhw.tema7.model.ProductType;
import com.dbhw.tema7.repository.ProductRepository;
import com.dbhw.tema7.service.ProductService;
import com.dbhw.tema7.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ProductService.class)
public class ProductServiceTest {
    @MockBean
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    public void it_should_update_stock() throws Exception{
        Product myProduct = new Product(null, ProductType.ELB, "Masina_de_spalat", "ABC123", 100, false, 1700);
    }

}
