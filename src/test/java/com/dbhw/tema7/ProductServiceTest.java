package com.dbhw.tema7;

import com.dbhw.tema7.model.Product;
import com.dbhw.tema7.model.ProductType;
import com.dbhw.tema7.repository.ProductRepository;
import com.dbhw.tema7.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ProductService.class)
public class ProductServiceTest {
    @MockBean
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void it_should_add_product() throws Exception{
        Product myProduct = new Product(null, ProductType.ELB, "Masina_de_spalat", "ABC123", 100, false, 1700);
        when(productRepository.save(any(Product.class))).thenReturn(new Product());
        Product created = productService.addProduct("Masina_de_spalat", "ABC123", ProductType.ELB,100);
        assertThat(created.getName()).isSameAs(myProduct.getName());
    }

}
