package com.shop.demo.service;

import com.shop.demo.data.Product;
import com.shop.demo.exceptions.SearchException;

import java.util.List;

public interface ShopService {
    Product save(Product product);

    void delete(Long id);

    List<Product> search(String name) throws SearchException;

    List<Product> findAll();

    Integer inventoryValue();
}
