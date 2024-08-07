package com.shop.demo;

import com.shop.demo.data.Category;
import com.shop.demo.data.Product;
import com.shop.demo.repositories.ShopRepository;
import com.shop.demo.service.ShopService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ShopServiceTest {
    @Autowired
    private ShopService shopService;
    private ShopRepository shopRepository = Mockito.mock();
    private List<Product> testingProducts;

    private void settings(){
       testingProducts =  List.of(
               new Product("Egg",12, Category.ELECTRONICS,"35"),
               new Product("Potato",5, Category.FOOD,"20"),
               new Product("Tomato",5, Category.FOOD,"20"),
               new Product("Shirt",50, Category.CLOTHING,"10"));
    }

    @Test
    public void save_one_product(){
        var product = new Product("Phone", 150,Category.ELECTRONICS,"7");
        var product5 = shopService.save(product);
        assertEquals(product.getName(),product5.getName());
    }

    @Test
    public void search_one_product(){
        settings();
        var expected = "Egg";
        List<Product> target = testingProducts.stream().filter(Product -> Product.getName().equals(expected)).toList();
        testingProducts.forEach(shopService::save);
        List<Product> searchProducts = shopService.search(expected);
        assertTrue(listProductEquals(target, searchProducts));

    }

    public void delete_one_product(){

    }

    private boolean listProductEquals(List<Product> x, List<Product> y) {
        boolean equals = true;
        for (int i = 0; i < x.size(); i++) {
            equals = x.get(i).getName().equals(y.get(i).getName());
        }
        return equals;
    }

}
