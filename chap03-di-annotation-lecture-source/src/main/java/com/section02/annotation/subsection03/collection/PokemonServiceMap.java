package com.section02.annotation.subsection03.collection;

import com.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("pokemonServiceCollectionMap")
public class PokemonServiceMap {
    /**
     * <h1>맵을 통한 생성자 주입</h1>
     * */
    private Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonServiceMap(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    /*설명. 키값은 빈의 id가 넘어오고, value 는 빈 객체의 주소값이 넘어온다!!*/
    public void pokemonAttack() {
        pokemonMap.forEach((k,v)->{
            System.out.println("k = " + k);
            System.out.println("v = " + v);
            v.attack();
        });
    }
}
