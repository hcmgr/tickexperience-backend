package com.deco.tickexperience.service;

import com.deco.tickexperience.model.dto.LoginDTO;
import com.deco.tickexperience.model.dto.TokenDTO;
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
    final private TokenService tokenService;

    public TokenDTO login(final LoginDTO loginDTO) {
        return login(loginDTO.getUsername(), loginDTO.getPassword());
    }

    public  TokenDTO login(final String username, final String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        if (!user.getPassword().equals(encodePassword(password))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }

        return new TokenDTO(tokenService.generateToken(user));
    }

    /**
     * Logout user via token issued on login
     * @param token token issued on login
     */
    public void logout(final String token) {
        tokenService.removeToken(token);
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

    public boolean check(final String token) {
        return tokenService.checkToken(token);
    }

    private String encodePassword(final String password) {
        return password;
    }
}
