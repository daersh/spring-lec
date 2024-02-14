package com.section02.annotation.subsection05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("com/section02/annotation");

        PokemonService pokemonService = ac.getBean("pokemonServiceInject",PokemonService.class);
        pokemonService.pokemonAttack();
    }
}
