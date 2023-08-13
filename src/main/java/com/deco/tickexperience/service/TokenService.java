package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TokenService {

    private final static Map<String, User> tokens = new HashMap<>();

    public String generateToken(User user) {
        // FIXME need to do this properly
        String token = user.getUsername();
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
