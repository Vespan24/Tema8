package com.dbhw.tema7;

import com.dbhw.tema7.controller.ShoppingCartController;
import com.dbhw.tema7.model.Product;
import com.dbhw.tema7.model.ProductType;
import com.dbhw.tema7.model.ShoppingCart;
import com.dbhw.tema7.repository.ShoppingCartRepository;
import com.dbhw.tema7.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ShoppingCartService.class)
public class ShoppingCartServiceTest {
    @MockBean
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void it_should_create_shopping_cart() throws Exception{
        Product myProduct1 = new Product(null, ProductType.ELB, "Masina_de_spalat", "ABC123", 100, false, 1700);
        Product myProduct2 = new Product(null, ProductType.ELB, "Masina_de_spalat", "ABC123", 100, false, 1700);
        List<Product> myList = new ArrayList<Product>();
        myList.add(myProduct1);
        myList.add(myProduct2);
        ShoppingCart myShoppingCart = new ShoppingCart(null, myList);
        when(shoppingCartRepository.save(any(ShoppingCart.class))).thenReturn(new ShoppingCart());
        ShoppingCart created = shoppingCartService.createShoppingCart();
        assertThat(created.getProductList()).isSameAs(myShoppingCart.getProductList());
    }
}
