package com.revature.pokedex.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon implements Comparable<Pokemon>{
    @JsonProperty("id")
    private int dexId;
    private String name;
    private List<Types> types;

    private Pokemon() {
        this.types = new ArrayList<>();
    }

    public static Pokemon of() {
        return new Pokemon();
    }

    public Pokemon id(int id) {
        this.dexId = id;
        return this;
    }

    public Pokemon name(String name) {
        this.name = name;
        return this;
    }

    public Pokemon type1(Types type1) {
        types.add(type1);
        return this;
    }

    public Pokemon type2(Types type2) {
        types.add(type2);
        return this;
    }

    public int getDexId() {
        return dexId;
    }

    public void setDexId(int dexId) {
        this.dexId = dexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "dexId=" + dexId +
                ", name='" + name + '\'' +
                ", types=" + types +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return dexId == pokemon.dexId && name.equals(pokemon.name) && types.equals(pokemon.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexId, name, types);
    }

    @Override
    public int compareTo(Pokemon o) {
        return Integer.compare(this.dexId, o.getDexId());
    }
}
