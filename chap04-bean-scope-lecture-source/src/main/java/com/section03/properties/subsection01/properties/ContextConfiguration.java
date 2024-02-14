package com.section03.properties.subsection01.properties;

import com.common.Beverage;
import com.common.Bread;
import com.common.Product;
import com.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource(value = "section03/properties/subsection01/properties/product-info/product-info.properties", encoding = "UTF-8")
public class ContextConfiguration {

    @Value("${bread.carpBread.name}")
    private String carpBreadName;
    @Value("${bread.carpBread.price}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name}")
    private String milkName;
    @Value("${beverage.milk.price}")
    private int milkPrice;
    @Value("${beverage.milk.capacity}")
    private int milkCapacity;

    @Bean
    public Product carpBread(){
        return new Bread(carpBreadName,carpBreadPrice,new java.util.Date());
    }

    @Bean
    Product milk(){
        return new Beverage(milkName,milkPrice,milkCapacity);
    }
    @Bean
    Product water(
            @Value("${beverage.water.name}") String waterName,
            @Value("${beverage.water.price}") int waterPrice,
            @Value("${beverage.water.capacity}") int waterCapacity
    ){
        return new Beverage(waterName,waterPrice,waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

}
