package com.section02.annotation.subsection05.inject;

import com.section02.annotation.common.Pokemon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceInject")
public class PokemonService {


    /** 1. Inject 라이브러리를 활용한 필드 주입*/
//    @Inject
//    @Named("squirtle")  // 항상 이렇게 두 어노테이션이 짝으로 되어야하는듯
    private Pokemon pokemon;

    /**2. 생성자 주입*/
//    @Inject
//    public PokemonService(@Named("charmander") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    /**<h1>3.Setter 주입</h1>*/
    @Inject
    public void setPokemon(@Named("squirtle")Pokemon pokemon){
        this.pokemon = pokemon;
    }



    public void pokemonAttack() {
        pokemon.attack();
    }
}
