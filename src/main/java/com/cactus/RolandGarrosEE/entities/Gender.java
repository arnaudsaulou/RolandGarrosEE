package com.cactus.RolandGarrosEE.entities;

public enum Gender {
    HOMME ("HOMME"),
    FEMME ("FEMME");

    private final String name;

    private Gender(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
