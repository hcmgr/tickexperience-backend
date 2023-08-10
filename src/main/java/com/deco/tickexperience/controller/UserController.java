package com.deco.tickexperience.controller;

import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${apiAuthedPrefix}/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/tickets")
    public List<Ticket> getTicketsForUser(@RequestHeader("token") String token) {
        return userService.getTicketsForUser(token);
    }

}
