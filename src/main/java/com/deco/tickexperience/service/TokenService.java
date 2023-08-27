package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {

    private final static Map<String, User> tokens = new HashMap<>();
    private final static SecureRandom random = new SecureRandom();

    public String generateToken(User user) {
        int TOKEN_LEN = 16;
        byte[] randomBytes = new byte[TOKEN_LEN];
        random.nextBytes(randomBytes);

        String token = UUID.nameUUIDFromBytes(randomBytes).toString();
        tokens.put(token, user);
        return token;
    }

    public User getUser(String token) {
        return tokens.get(token);
    }

    public void removeToken(String token) {
        tokens.remove(token);
    }

    public boolean checkToken(final String token) {
        return tokens.containsKey(token);
    }
}
