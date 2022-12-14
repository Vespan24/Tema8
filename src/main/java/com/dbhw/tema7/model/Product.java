package com.dbhw.tema7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private ProductType type;
    private String name;
    private String identificationCode;
    private Integer stock;
    private Boolean deleted = false;
    private Integer price;

    private boolean isDeleted(){
        if(this.deleted==true)
            return true;
        else
            return false;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
