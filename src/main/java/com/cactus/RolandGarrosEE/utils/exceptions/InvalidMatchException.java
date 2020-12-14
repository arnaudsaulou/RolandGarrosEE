package com.cactus.RolandGarrosEE.utils.exceptions;

public class InvalidMatchException extends Exception {

    public InvalidMatchException() {
        super("Le format de match est invalide");
    }

    public InvalidMatchException(String message) {
        super(message);
    }
}
