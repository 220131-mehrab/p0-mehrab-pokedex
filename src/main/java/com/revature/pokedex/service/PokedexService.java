package com.revature.pokedex.service;

import com.revature.pokedex.domain.Pokemon;
import com.revature.pokedex.repository.DexRepository;

import java.util.List;

public class PokedexService {
    private DexRepository dexRepository;

    public PokedexService(DexRepository dexRepository) {
        this.dexRepository = dexRepository;
    }

    public String searchForm() {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Search Pokedex" +
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "    <h1>Pokedex Search</h1>\n" +
                "    <form action='pokemon' method='get'>\n" +
                "        <input type='name' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    " +
                "    <a href='pokemon'>See Full Pokedex</a>\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        return HTMLForm;
    }

    public List<Pokemon> getPokemon() {
        return dexRepository.getPocketMonsters();
    }

    public Pokemon getPokemon(String userInput) {
        return dexRepository.getPokemon(userInput.trim().toLowerCase());
    }
}
