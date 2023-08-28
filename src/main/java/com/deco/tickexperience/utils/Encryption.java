package com.deco.tickexperience.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.SecureRandom;
import java.util.UUID;

public class Encryption {
    public static String generateSalt() {
        byte[] salt = generateBytes(16);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String generateToken() {
        // TODO: maybe want variable length tokens?
        byte[] randomBytes = generateBytes(16);
        return UUID.nameUUIDFromBytes(randomBytes).toString();
    }

    private static byte[] generateBytes(int len) {
        // TODO: perhaps insecure to have new instance everytime
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[len];
        random.nextBytes(randomBytes);
        return randomBytes;
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
