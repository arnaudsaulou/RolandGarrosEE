package com.cactus.RolandGarrosEE.entities;

public enum TypeTournament {
    SINGLE("Single"),
    DOUBLE("Double");

    private final String name;

    TypeTournament(String s) {
        this.name = s;
    }

    public boolean equalsName(String otherName) {
        return this.name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

    public static TypeTournament getTypeTournamentFromString(String typeTournamentString){
        for (TypeTournament typeTournament : TypeTournament.values()) {
            if(typeTournament.equalsName(typeTournamentString)){
                return typeTournament;
            }
        }
        throw new IllegalArgumentException(typeTournamentString + "Not a valid tournament type");
    }
}
