package com.deco.tickexperience.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

@Service
public class EncryptionService {

    private final SecureRandom random = new SecureRandom();
    private final MessageDigest messageDigest;

    @Value("${token.length}")
    private int tokenLength;

    public EncryptionService() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available.", e);
        }
    }

    public String generateSalt() {
        byte[] salt = generateBytes(16);
        return Base64.getEncoder().encodeToString(salt);
    }

    public String generateToken() {
        byte[] randomBytes = generateBytes(tokenLength);
        return UUID.nameUUIDFromBytes(randomBytes).toString();
    }

    private byte[] generateBytes(int len) {
        byte[] randomBytes = new byte[len];
        random.nextBytes(randomBytes);
        return randomBytes;
    }

    public String hashPasswordWithSalt(String password, String salt) {
        byte[] passwordAndSalt = concatBytes(password.getBytes(), salt.getBytes());
        byte[] hashedBytes = SHA256(passwordAndSalt);
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    private byte[] concatBytes(byte[] array1, byte[] array2) {
        byte[] combined = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, combined, 0, array1.length);
        System.arraycopy(array2, 0, combined, array1.length, array2.length);
        return combined;
    }

    private byte[] SHA256(byte[] input) {
        return messageDigest.digest(input);
    }
}
