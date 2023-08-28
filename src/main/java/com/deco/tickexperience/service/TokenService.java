package com.deco.tickexperience.service;
import com.deco.tickexperience.model.entity.User;
import com.deco.tickexperience.utils.Encryption;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    private final static Map<String, User> tokens = new HashMap<>();

    public String generateToken(User user) {
        String token = Encryption.generateToken();
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
