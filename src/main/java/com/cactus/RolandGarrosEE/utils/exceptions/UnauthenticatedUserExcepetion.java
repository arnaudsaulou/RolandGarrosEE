package com.cactus.RolandGarrosEE.utils.exceptions;

public class UnauthenticatedUserExcepetion extends Exception{

    public UnauthenticatedUserExcepetion() {
        super("Connexion requise pour afficher cette page");
    }
}
