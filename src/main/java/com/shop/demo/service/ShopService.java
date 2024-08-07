package com.shop.demo.service;
import com.shop.demo.data.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShopService {
    Product save(Product product);

    void delete(Product product);

    List<Product> search(String name);

    List<Product> findAll();

    Integer inventoryValue();
}
