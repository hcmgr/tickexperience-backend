package com.deco.tickexperience.controller;

import com.deco.tickexperience.model.dto.MyTicketDTO;
import com.deco.tickexperience.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${apiPrefix}/ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{ticketId}")
    public MyTicketDTO getTicket(@PathVariable Long ticketId) {
        return ticketService.getTicket(ticketId);
    }
}
