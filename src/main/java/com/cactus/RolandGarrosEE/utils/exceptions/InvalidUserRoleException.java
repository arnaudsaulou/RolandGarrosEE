package com.cactus.RolandGarrosEE.utils.exceptions;

public class InvalidUserRoleException extends Exception{
    public InvalidUserRoleException() {
        super("Role utilisateur invalide");
    }
}
