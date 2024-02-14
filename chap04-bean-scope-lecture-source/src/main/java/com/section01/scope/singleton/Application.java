package com.section01.scope.singleton;

import com.common.Beverage;
import com.common.Bread;
import com.common.Product;
import com.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    /**
     * <h2>Spring Scope</h2>
     * 스프링 빈이 생성될 때 해당 인스턴스의 범위를 의미한다. 스프링에서는 다양한 scope를 제공한다.
     * @1.singleton:    하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴스를 공유한다.
     * @2.prototype:    매번 새로운 인스턴스를 생성한다.
     * @3.request:      Http 요청을 처리할 때마다 새로운 인스턴스를 생성하고, 요청 처리 끝나면 폐기한다. (웹 애플리케이션 컨텍스트만 해당)
     * @4.session:      Http 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 인스턴스를 폐기한다. (웹 애플리케이션 컨텍스트만 해당)
     * @5.globalSession: 전역 세션 당 하나의 인스턴스를 생성하고, 전역 세션이 종료되면 인스턴스를 폐기한다. (포턴 애플리케이션 컨테스트만 해당)
     *
     * */

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = ac.getBeanDefinitionNames();
        for(String beanName: beanNames){
            System.out.println(beanName);
        }

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
        System.out.println("cart2.getItems() = " + cart2.getItems());   //결과. scope변경 전
                                                                        // 카트1의 데이터와 2에 추가된 물 다 출력
        System.out.println("cart1 = " + cart1.getItems());              //  결과. 카트1도 영향을 받음!
        System.out.println(System.identityHashCode(cart1) == System.identityHashCode(cart2));   //결과. true
            //중요. 쇼핑 카트에 대한 bean을 @Scope("prototype")로 하면 요청할 때마다 새로운 객체를 선언한다!!

    }
}
