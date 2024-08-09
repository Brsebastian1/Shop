package com.shop.demo.data;

import jakarta.persistence.*;

@Entity
@Table
public class Product {
    @Column
    private String name;

    @Column
    private int price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer code;

    @Column
    private Category category;

    @Column
    private String stock;

    public Product(String name, int price, Category category, String stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
