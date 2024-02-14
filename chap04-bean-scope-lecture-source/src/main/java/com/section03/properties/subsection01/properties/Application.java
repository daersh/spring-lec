package com.section03.properties.subsection01.properties;

import com.common.Beverage;
import com.common.Bread;
import com.common.Product;
import com.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /*설명. 붕어빵, 딸기우유, 지리산암반수 빈 객체를 반환받아 변수에 담는다.*/
        Product carpBread = ac.getBean("carpBread", Bread.class);
        Product milk = ac.getBean("milk", Beverage.class);
        Product water = ac.getBean("water", Beverage.class);
        System.out.println("carpBread = " + carpBread);
        System.out.println("milk = " + milk);
        System.out.println("water = " + water);

        /*설명. 첫번째 손님이 쇼핑카트를 꺼내 물건을 담는다.*/
        ShoppingCart cart1 = ac.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        /*설명. 첫 손님의 쇼핑 카트에 담긴 물품 확인*/
        System.out.println("cart1 = " + cart1.getItems());

        /*설명. 두번째 손님이 쇼핑카트를 꺼내 물건을 담는다.*/
        ShoppingCart cart2 = ac.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        /*설명. 두번째 손님의 쇼핑 카트에 담긴 물품 확인*/
        System.out.println("cart2.getItems() = " + cart2.getItems());
        System.out.println("cart1 = " + cart1.getItems());
        System.out.println(System.identityHashCode(cart1) == System.identityHashCode(cart2));
    }
}
