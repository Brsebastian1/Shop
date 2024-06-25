package com.shop.demo.repositories;

import com.shop.demo.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShopRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
