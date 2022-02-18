package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Pokemon;
import com.revature.pokedex.domain.Types;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDexRepository implements DexRepository{
    private List<Pokemon> pocketMonsters;

    public InMemoryDexRepository() {
        pocketMonsters = new ArrayList<>();
        pocketMonsters.add(Pokemon.of().id(1).name("Bulbasaur").type1(new Types(1, "Grass")).type2(new Types(2, "Poison")));
    }

    public List<Pokemon> getPocketMonsters() {
        return pocketMonsters;
    }

    public Pokemon getPokemon(String name) {
        Pokemon result = null;
        for (Pokemon pokemon : this.pocketMonsters) {
            if (pokemon.getName().equals(name)) {
                result = pokemon;
            }
        }
        return result;
    }
}
