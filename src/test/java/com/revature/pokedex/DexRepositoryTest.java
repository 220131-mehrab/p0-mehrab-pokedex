package com.revature.pokedex;

import com.revature.pokedex.domain.Pokemon;
import com.revature.pokedex.domain.Types;
import com.revature.pokedex.repository.CSVDexRepository;
import com.revature.pokedex.repository.PokeAPIDexRepository;
import com.revature.pokedex.repository.SQLDexRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DexRepositoryTest {
    @Test
    public void getCSVPokemonTest() {
        CSVDexRepository testRepo = new CSVDexRepository("pokedextest.csv");
        Pokemon actual = testRepo.getPokemon("Bulbasaur");
        Pokemon expected = Pokemon.of().name("Bulbasaur");
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void getAPIPokemonTest() {
        PokeAPIDexRepository testRepo = new PokeAPIDexRepository();
        System.out.println(testRepo.getPokemon("mew"));
    }

    @Test
    public void getSQLPokemonTest() {
        SQLDexRepository testRepo = new SQLDexRepository();
        Pokemon actual = Pokemon.of().id(1).name("Bulbasaur").type1(new Types(1, "Grass")).type2(new Types(2, "Poison"));
        Assertions.assertEquals(actual, testRepo.getPokemon("Bulbasaur"));
    }
}
