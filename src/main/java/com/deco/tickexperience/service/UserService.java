package com.deco.tickexperience.service;

import com.deco.tickexperience.model.dto.MyTicketDTO;
import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.model.entity.User;
import com.deco.tickexperience.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenService tokenService;

    public List<Ticket> getTicketsForUser(final String token) {
       String username = tokenService.getUser(token).getUsername();

       return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found " + username))
                .getTickets();
    }

    public User getUserDetails(final String token) {
        String username = tokenService.getUser(token).getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found " + username));
    }

    public List<MyTicketDTO> getMyTickets(final String token) {
        return dummyData(); // TODO remove dummy data stuff
//        String username = tokenService.getUser(token).getUsername();
//
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found " + username))
//                .getTickets()
//                .stream()
//                .map(this::createMyTicketDTO)
//                .collect(Collectors.toList());
    }

    private List<MyTicketDTO> dummyData() {
        MyTicketDTO dto1 = new MyTicketDTO(1L, LocalDateTime.now(), "Running", "The Gabba", "TODO");
        return List.of(dto1);
    }

    private MyTicketDTO createMyTicketDTO(final Ticket ticket) {
        MyTicketDTO dto = new MyTicketDTO();
        dto.setTicketId(ticket.getId());
        dto.setEventName(ticket.getEvent().getName());
        dto.setEventDateTime(ticket.getEvent().getStartTime());
        dto.setVenueName(ticket.getEvent().getVenue().getName());
        dto.setImageUrl("TODO");
        return dto;
    }

}
