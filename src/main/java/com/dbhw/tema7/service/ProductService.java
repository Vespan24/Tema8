package com.dbhw.tema7.service;

import com.dbhw.tema7.model.Product;
import com.dbhw.tema7.model.ProductType;
import com.dbhw.tema7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;

    public Product addProduct(String name, String identificationCode, ProductType type, Integer stock){
        Product product= new Product();
        product.setDeleted(false);
        product.setName(name);
        product.setIdentificationCode(identificationCode);
        product.setStock(stock);
        product.setType(type);
        return productRepository.save(product);
    }

    public void softDeleteProduct(String identificationCode){
        productRepository.getByIdentificationCode(identificationCode).setDeleted(false);
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll()
                .stream()
                .filter(p -> p.getDeleted()==false);
    }
    public List<Product> getAllProductsIncludingDeleted(){
        return productRepository.findAll();
    }
    public void incrementStockByOne(Integer Id){
        productRepository.incrementStock(Id);
    }
    public void decrementStockByOne(Integer Id){
        productRepository.decrementStock(Id);
     /*
        if(productsRepository.getById(Id).getStock() <= 0){
            softDeleteProduct(productsRepository.getById(Id).getIdentificationCode());
        }
     */
    }
    public void updateStock(Integer Id, Integer stock){
        productRepository.getById(Id).setStock(stock);
    }
}
