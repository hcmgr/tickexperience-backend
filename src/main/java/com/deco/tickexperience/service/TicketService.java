package com.deco.tickexperience.service;

import com.deco.tickexperience.model.dto.MyTicketDTO;
import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public MyTicketDTO getTicket(final Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found for id: " + id));

        MyTicketDTO dto = new MyTicketDTO();
        dto.setTicketId(ticket.getId());
        dto.setIcon(ticket.getEvent().getSport().getIcon());
        dto.setEventName(ticket.getEvent().getName());
        dto.setVenueId(ticket.getEvent().getVenue().getId());
        dto.setVenueName(ticket.getEvent().getVenue().getName());
        dto.setSeatNumber(ticket.getSeatNumber());
        dto.setEventDateTime(ticket.getEvent().getStartTime());
        dto.setQrCode(ticket.getQRCode());
        dto.setVideoUrls(ticket.getEvent().getSport().getVideoUrlsAsStrings());

        return dto;
    }

}
