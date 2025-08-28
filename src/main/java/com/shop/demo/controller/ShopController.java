package com.shop.demo.controller;

import com.shop.demo.data.Product;
import com.shop.demo.service.ShopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return shopService.save(product);
    }
}
