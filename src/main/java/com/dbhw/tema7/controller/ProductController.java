package com.dbhw.tema7.controller;

import com.dbhw.tema7.model.Product;
import com.dbhw.tema7.model.ProductType;
import com.dbhw.tema7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products/addproduct/")
    public void addProduct(@RequestParam String name, @RequestParam String identificationCode, @RequestParam ProductType type, @RequestParam Integer stock){
        productService.addProduct(name, identificationCode, type, stock);
    }

    @DeleteMapping("/products/softdelete/{identificationCode}")
    public void softDeleteProduct(@PathVariable("identificationCode") String identificationCode){
        productService.softDeleteProduct(identificationCode);
    }
    @GetMapping("products/all/undeleted")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("products/all/all")
    public List<Product> getAllProductsIncludingUndeleted(){
        return productService.getAllProductsIncludingDeleted();
    }

    @PostMapping("products/decrement/{Id}")
    public void decrementStockByOne(@PathVariable("Id") Integer Id){
        productService.decrementStockByOne(Id);
    }
    @PostMapping("products/increment/{Id}")
    public void incrementStockByOne(@PathVariable("Id") Integer Id){
        productService.incrementStockByOne(Id);
    }

    @PostMapping("products/updatestock/{id}/{stock}")
    public void updateStock(@PathVariable Integer id, @PathVariable Integer stock) {
        productService.updateStock(id, stock);
    }
}
