package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SQLDexRepositoryTest {
    DexRepository testRepo;

    @BeforeEach
    void setUp() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        testRepo = new SQLDexRepository(conn);
    }

    @Test
    void getPokemon() {
        Pokemon actual = testRepo.getPokemon("Bulbasaur");
        Assertions.assertEquals("Bulbasaur", actual.getName());
    }

    @Test
    void getPocketMonsters() {
        List<Pokemon> actual = testRepo.getPocketMonsters();
        Assertions.assertEquals("Bulbasaur", actual.get(0).getName());
    }
}