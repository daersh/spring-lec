package com.section02.annotation.subsection04.resource;

import com.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceResource")
public class PokemonService {


    @Resource(name = "charmander")
    private Pokemon pokemon;
    @Resource
    private List<Pokemon> pokemonList;

    @Resource
    private Map<String,Pokemon> pokemonMap;

    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        System.out.println("Pokemon");
        pokemon.attack();
    }
    public void pokemonAttack2(){
        System.out.println("List");
        pokemonList.forEach(Pokemon::attack);
    }
    public void pokmonAttack3(){
        System.out.println("Map");
        pokemonMap.forEach((k,v)->{
                    v.attack();
                }
                );
    }


}
