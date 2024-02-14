package com.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /**
     * <h1>Collection- List,Map</h1>
     * 같은 타입의 빈이 2개 이상일 경우 List, Map 두가지로 컬렉션 형태로 주입 받을 수 있다.
     *
     * */

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("com/section02/annotation");

        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames){
            System.out.println("beanName = " + beanName);
        }

        PokemonServiceList pokemonService = ac.getBean("pokemonServiceCollectionList", PokemonServiceList.class);
        pokemonService.pokemonAttack();
        PokemonServiceMap pokemonServiceMap = ac.getBean("pokemonServiceCollectionMap", PokemonServiceMap.class);
        pokemonServiceMap.pokemonAttack();
    }
}
