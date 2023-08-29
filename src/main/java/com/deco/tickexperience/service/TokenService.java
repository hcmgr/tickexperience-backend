package com.deco.tickexperience.service;
import com.deco.tickexperience.model.ActiveUser;
import com.deco.tickexperience.model.entity.User;
import com.deco.tickexperience.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {

    private final EncryptionService encryptionService;
    private final UserRepository userRepository;

    @Value("${token.timeout}")
    private long tokenTimeout;

    private final static Map<String, ActiveUser> tokens = new HashMap<>();

    public String generateToken(Long userId) {
        String token = encryptionService.generateToken();
        ActiveUser activeUser = new ActiveUser(userId, LocalDateTime.now());
        tokens.put(token, activeUser);
        return token;
    }

    public User getUser(String token) {
        Long userId = tokens.get(token).getUserId();
        return userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found") // this should never happen
        );
    }

    public void removeToken(String token) {
        tokens.remove(token);
    }

    public boolean checkToken(final String token) {
        ActiveUser activeUser = tokens.get(token);

        if (activeUser == null) {
            log.info("Token not found: {}", token);
            return false;
        }

        if (activeUser.getLastActiveTime().isBefore(LocalDateTime.now().minusSeconds(tokenTimeout))) {
            log.info("Token expired: {}", token);
            tokens.remove(token);
            return false;
        }

        // update token time
        activeUser.setLastActiveTime(LocalDateTime.now());
        return true;
    }
}
