package com.deco.tickexperience.controller;

import com.deco.tickexperience.model.dto.LoginDTO;
import com.deco.tickexperience.model.dto.RegisterDTO;
import com.deco.tickexperience.model.dto.TokenDTO;
import com.deco.tickexperience.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthenticationController
 * handles all authentication related requests
 * does not require authentication to use
 */
@RestController
@RequestMapping("${apiPrefix}/auth")
@RequiredArgsConstructor
public class AuthController {

    final private AuthService authService;

    /**
     * Login with username and pw
     * @return String token for api usage
     */
    @PostMapping("/login")
    public TokenDTO login(@RequestBody final LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }

    @PostMapping("/register")
    public TokenDTO register(@RequestBody final RegisterDTO registerDTO) {
        return authService.register(registerDTO);}

    @PostMapping("/logout/{token}")
    public void logout(@PathVariable String token) {
        authService.logout(token);
    }

    /**
     * Check if token is still valid
     * @param token auth token
     * @return true if token is valid
     */
    @GetMapping("/check/{token}")
    public boolean check(@PathVariable String token) {
        return authService.check(token);
    }
}




