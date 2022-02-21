package com.revature.pokedex.repository;

import com.revature.pokedex.domain.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLDexRepository implements DexRepository{
    private String selectAll = "Select pokemon.id, name, type1, type2 from pokemon, types where pokemon.type=types.id";
    private Connection connection;

    public SQLDexRepository(Connection connection) {
        this.connection  = connection;
    }

    @Override
    public Pokemon getPokemon(String name) {
        Pokemon result = null;
        try {
            String query = selectAll + " and name = '"+ name + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                result = Pokemon.of()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .type1(resultSet.getString("type1"))
                        .type2(resultSet.getString("type2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Pokemon> getPocketMonsters() {
        List<Pokemon> results = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute(selectAll);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Pokemon result = Pokemon.of()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .type1(resultSet.getString("type1"))
                        .type2(resultSet.getString("type2"));
                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
