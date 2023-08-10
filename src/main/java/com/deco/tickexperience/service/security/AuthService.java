package com.deco.tickexperience.service.security;

import com.deco.tickexperience.model.entity.User;
import com.deco.tickexperience.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class AuthService {

    final private UserRepository userRepository;

    public String login(final String username, final String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        if (!user.getPassword().equals(encodePassword(password))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }

        return TokenService.generateToken(user);
    }

    /**
     * Logout user via token issued on login
     * @param token token issued on login
     */
    public void logout(final String token) {
        TokenService.removeToken(token);
    }

    public void register(final String username, final String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodePassword(password));
        userRepository.save(user);
    }


    private String encodePassword(final String password) {
        // TODO
        return password;
    }
}
