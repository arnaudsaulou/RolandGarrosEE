package com.cactus.RolandGarrosEE.utils.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Utilisateur non trouvé");
    }
}
