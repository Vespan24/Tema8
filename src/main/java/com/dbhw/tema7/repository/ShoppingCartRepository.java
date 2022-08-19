package com.dbhw.tema7.repository;

import com.dbhw.tema7.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    Integer totalPrice();
}
