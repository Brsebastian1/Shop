package com.shop.demo.service.impl;

import com.shop.demo.data.Product;
import com.shop.demo.repositories.ShopRepository;
import com.shop.demo.service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }
    @Override
    public Product save(Product product) {
        return shopRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        try {
            Integer id = product.getCode();
            shopRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {

        }
    }

    @Override
    public List<Product> search(String title) {
        var products = shopRepository.findByName(title);
        return List.of((Product) products);
    }

    @Override
    public List<Product> findAll() {
        var products = shopRepository.findAll();
        return List.of((Product) products);
    }

    @Override
    public Integer inventoryValue() {
        List<Product> products = findAll();
        int totalValue = 0;
        for(Product product : products){
            totalValue += product.getPrice();
        }
        return totalValue;
    }
}
