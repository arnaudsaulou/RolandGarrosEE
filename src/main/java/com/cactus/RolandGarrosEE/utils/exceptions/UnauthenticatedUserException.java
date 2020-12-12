package com.cactus.RolandGarrosEE.utils.exceptions;

public class UnauthenticatedUserException extends Exception{

    public UnauthenticatedUserException() {
        super("Connexion requise pour afficher cette page");
    }
}
