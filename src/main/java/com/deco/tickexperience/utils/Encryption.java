package com.deco.tickexperience.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.SecureRandom;

public class Encryption {
    public static String generateSalt() {
        // TODO: perhaps insecure to have new instance everytime
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPasswordWithSalt(String password, String salt) {
        byte[] passwordAndSalt = concatBytes(password.getBytes(), salt.getBytes());
        byte[] hashedBytes = SHA256(passwordAndSalt);
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    private static byte[] concatBytes(byte[] array1, byte[] array2) {
        byte[] combined = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, combined, 0, array1.length);
        System.arraycopy(array2, 0, combined, array1.length, array2.length);
        return combined;
    }

    private static byte[] SHA256(byte[] input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(input);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available.", e);
        }
    }
}
