package com.cactus.RolandGarrosEE.utils.enums;

import com.cactus.RolandGarrosEE.utils.exceptions.InvalidUserRoleException;

public enum UserRole {
    ADMIN(0),
    ORGANIZER(1),
    JOURNALIST(2);

    private final int value;

    UserRole(int i) {
        this.value = i;
    }

    public boolean equalsValue(int otherValue) {
        return value == otherValue;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public static void checkUserRole(int x) throws InvalidUserRoleException {

        for (UserRole roles: UserRole.values()) {
            if(roles.value == x)
                break;
        }

        throw new InvalidUserRoleException();
    }

}
