package com.cactus.RolandGarrosEE.utils;

import com.cactus.RolandGarrosEE.utils.enums.UserRole;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class PasswordUtils {

    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;
    private static final String SALT = "DARMFcJcJDeNMmNMLkZN4rSnHV2OQPDd27yi5fYQ77r2vKTa";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    private static final String TOKEN_KEY_ADMIN = "NfheHLfhUzhdShfHfMcmzJFHv";
    private static final String TOKEN_KEY_ORGANIZER = "JOFJoOJIZfdmMDfcZedghOKFK";
    private static final String TOKEN_KEY_JOURNALIST = "FrLKJHGFIVDCRYppOHioLOIHG";

    public static Optional<String> hashPassword(String password) {

        char[] chars = password.toCharArray();
        byte[] bytes = SALT.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);

        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Exception encountered in hashPassword()");
            return Optional.empty();
        } finally {
            spec.clearPassword();
        }
    }

    public static boolean verifyPassword(String password, String passwordToTry) {
        Optional<String> hashedPasswordToTryOption = PasswordUtils.hashPassword(passwordToTry);
        String hashedPasswordToTry = null;

        if (hashedPasswordToTryOption.isPresent()) {
            hashedPasswordToTry = hashedPasswordToTryOption.get();
        }

        return password.equals(hashedPasswordToTry);
    }

    public static String generateToken(String username, UserRole role) {
        String tokenKey = null;

        switch (role) {
            case ADMIN:
                tokenKey = TOKEN_KEY_ADMIN;
                break;
            case ORGANIZER:
                tokenKey = TOKEN_KEY_ORGANIZER;
                break;
            case JOURNALIST:
                tokenKey = TOKEN_KEY_JOURNALIST;
                break;
            default:
                break;
        }

        Optional<String> hashedTokenOption = hashPassword(username + tokenKey);
        if (hashedTokenOption.isPresent())
            tokenKey = hashedTokenOption.get();

        return tokenKey;
    }

}
