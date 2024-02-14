package com.section02.annotation.subsection04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    /**
     * <h1>Resource annotation</h1>
     * Qualifier와 마찬가지로 Primart보다 더 높은 우선순위로 원하는 빈 이름으로 하나의 빈을 주입받을 수 있다.<br>
     * 객체 하나부터 Map, List까지 가능하다.
     * */
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("com/section02");

        PokemonService pokemonService = ac.getBean("pokemonServiceResource",PokemonService.class);
        pokemonService.pokemonAttack();
        pokemonService.pokemonAttack2();
        pokemonService.pokmonAttack3();
    }
}
