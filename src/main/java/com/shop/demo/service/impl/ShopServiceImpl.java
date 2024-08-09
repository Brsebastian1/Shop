package com.shop.demo.service.impl;

import com.shop.demo.data.Product;
import com.shop.demo.exceptions.SearchException;
import com.shop.demo.repositories.ShopRepository;
import com.shop.demo.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Product save(Product product) {
        return shopRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public List<Product> search(String name) throws SearchException {
        var products = shopRepository.findByName(name);
        if (products.isEmpty()) {
            throw new SearchException(name);
        }
        return products;

    }

    @Override
    public List<Product> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public Integer inventoryValue() {
        List<Product> products = findAll();
        int totalValue = 0;
        for (Product product : products) {
            totalValue += product.getPrice();
        }
        return totalValue;
    }
}
