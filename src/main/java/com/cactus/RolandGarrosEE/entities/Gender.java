package com.cactus.RolandGarrosEE.entities;

public enum Gender {
    HOMME("Homme"),
    FEMME("Femme"),
    MIXTE("Mixte");

    private final String name;

    Gender(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

    public static Gender getGenderFromString(String genderString) {
        for (Gender gender : Gender.values()) {
            if (gender.equalsName(genderString)) {
                return gender;
            }
        }
        throw new IllegalArgumentException(genderString + "Not a valid gender");
    }
}
