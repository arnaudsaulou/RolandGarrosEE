package com.cactus.RolandGarrosEE.entities;

public enum TypeTournament {
    SINGLE ("Simple"),
    DOUBLE ("Double");

    private final String name;

    private TypeTournament(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
