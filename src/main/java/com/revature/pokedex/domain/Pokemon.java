package com.revature.pokedex.domain;

import java.util.*;

public class Pokemon implements Comparable<Pokemon>{
    private int dexId;
    private String name;
    private List<Type> types;

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

    public Pokemon type1(String type1) {
        types.add(0, Type.valueOf(type1.toUpperCase()));
        return this;
    }

    public Pokemon type2(String type2) {
        try {
            types.add(1, Type.valueOf(type2.toUpperCase()));
        } catch (IllegalArgumentException ex) {}
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

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
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
