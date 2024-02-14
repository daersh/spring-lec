package com.section02.annotation.subsection01.primary;

import com.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")//?
public class PokemonService {

    private Pokemon pokemon;

//    @Autowired  //중요 이 어노테이션 없어도 자동으로 생성자 주입이 된다?!?!
    // 현재와 같이 포켓몬 타입이 빈이 2개 이상인 경우 Primary 어노테이션을 통해 하나의 빈만 주입 가능하다!
    public PokemonService(Pokemon pokemon) {    //설명. Primary가 되어 있는 피카츄가 온다!
        this.pokemon= pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
