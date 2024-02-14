package com.section02.annotation.subsection02.qualifier;

import com.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /**
     * <h1>Qualifier</h1>
     * Quialifier를 통해 원하는 빈 이름(id)로 하나의 빈을 주입 받을 수 있다. 이는 Primary보다 우선순위가 더 높다!
     * <br> 하지만 이건 지양할 것
     * */
    @Autowired
    @Qualifier("squirtle")      //중요. Primary 보다 더 우선으로 가져오도록 한다
    private Pokemon pokemon;

    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
