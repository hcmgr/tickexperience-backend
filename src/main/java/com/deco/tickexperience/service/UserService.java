package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Ticket> getTicketsForUser(final String token) {
       String username = TokenService.getUser(token).getUsername();

       return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found " + username))
                .getTickets();
    }
}
