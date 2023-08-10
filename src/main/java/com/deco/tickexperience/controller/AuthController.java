package com.deco.tickexperience.controller;

import com.deco.tickexperience.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    @PostMapping("/register")
    public void register(@RequestParam String username, @RequestParam String password) {
        authService.register(username, password);
    }

    @PostMapping("/logout")
    public void logout(@RequestParam String token) {
        authService.logout(token);
    }
}
