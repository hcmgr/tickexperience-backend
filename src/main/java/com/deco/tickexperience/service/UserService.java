package com.deco.tickexperience.service;

import com.deco.tickexperience.model.dto.MyTicketDTO;
import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.model.entity.User;
import com.deco.tickexperience.repository.TicketRepository;
import com.deco.tickexperience.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final TicketRepository ticketRepository;

    private final NotificationService notificationService;

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
        String username = tokenService.getUser(token).getUsername();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found " + username))
                .getTickets()
                .stream()
                .map(this::createMyTicketDTO)
                .collect(Collectors.toList());
    }

    private MyTicketDTO createMyTicketDTO(final Ticket ticket) {
        MyTicketDTO dto = new MyTicketDTO();
        dto.setTicketId(ticket.getId());
        dto.setEventName(ticket.getEvent().getName());
        dto.setEventDateTime(ticket.getEvent().getStartTime());
        dto.setVenueName(ticket.getEvent().getVenue().getName());
        dto.setIcon(ticket.getEvent().getSport().getIcon());
        return dto;
    }

    public void buyTicket(final String token, final Long ticketId) {
        User user = tokenService.getUser(token);
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ticket not found " + ticketId));

        user.addTicket(ticket);
        userRepository.save(user);

        boolean test = false;
        if (test) {
            notificationService.sendEmail("deco3801test@gmail.com", "test", "test");
        } else {
            notificationService.sendConfirmationEmail(user, ticket);
        }
    }
}
