package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TokenService {

    private final static Map<String, User> tokens = new HashMap<>();
    private final static Random random = new Random();
    private final static int MAX_INT = 1000000;

    /*
    TODO map token to user and last access time, and kill tokens
        after certain inactive period (10 minutes?). Just
        check in the filter and kill the token there.
     */

    public String generateToken(User user) {
//        String token = String.valueOf(random.nextInt(MAX_INT));
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
