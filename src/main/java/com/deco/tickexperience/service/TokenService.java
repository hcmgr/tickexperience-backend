package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.User;

import java.util.HashMap;
import java.util.Map;

public class TokenService {

    private final static Map<String, User> tokens = new HashMap<>();


    public static String generateToken(User user) {
        // FIXME add randomness and hashing
        String token = user.getUsername() + user.getPassword();
        tokens.put(token, user);
        return token;
    }

    public static User getUser(String token) {
        return tokens.get(token);
    }

    public static void removeToken(String token) {
        tokens.remove(token);
    }

    public static boolean checkToken(final String token) {
        return tokens.containsKey(token);
    }
}
