package com.cactus.RolandGarrosEE.utils.exceptions;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException() {
        super("Mot de passe invalide");
    }
}
