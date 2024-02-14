package com.section02.annotation.subsection03.collection;

import com.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollectionList")
public class PokemonServiceList {

    private List<Pokemon> pokemonList;

    @Autowired
    public PokemonServiceList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void pokemonAttack() {
        pokemonList.forEach(Pokemon::attack);   //참고 '::' 참조하겠다는 뜻~
    }
}
