package com.deco.tickexperience.service;

import com.deco.tickexperience.model.dto.LoginDTO;
import com.deco.tickexperience.model.dto.RegisterDTO;
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
    final private EncryptionService encryptionService;

    public TokenDTO login(final LoginDTO loginDTO) {
        return login(loginDTO.getUsername(), loginDTO.getPassword());
    }

    public  TokenDTO login(final String username, final String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        if (!user.getPasswordHash().equals(encodePassword(password, user.getUserSalt()))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }

        return new TokenDTO(tokenService.generateToken(user.getId()));
    }

    /**
     * Logout user via token issued on login
     * @param token token issued on login
     */
    public void logout(final String token) {
        tokenService.removeToken(token);
    }
    public void register(final RegisterDTO registerDTO) {

        if (userRepository.findByUsername(registerDTO.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }

        User user = new User();
        String salt = encryptionService.generateSalt();

        user.setUsername(registerDTO.getUsername());
        user.setUserSalt(salt);
        user.setPasswordHash(encodePassword(registerDTO.getPassword(), salt));
        user.setName(registerDTO.getName());

        userRepository.save(user);
    }

    public boolean check(final String token) {
        return tokenService.checkToken(token);
    }

    private String encodePassword(final String password, final String salt) {
        return encryptionService.hashPasswordWithSalt(password, salt);
    }
}
