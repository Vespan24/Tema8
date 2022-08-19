package com.dbhw.tema7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbhw.tema7.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getById(Integer Id);
    Product getByIdentificationCode(String identificationCode);
    List<Product> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Product p set p.stock = p.stock +1 WHERE p.Id = :productId")
    void incrementStock(Integer productId);

    @Transactional
    @Modifying
    @Query("UPDATE Product p set p.stock = p.stock -1 WHERE p.Id = :productId")
    void decrementStock(Integer productId);
}
