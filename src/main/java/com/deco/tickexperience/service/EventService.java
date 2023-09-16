package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Event;
import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event getEvent(final Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found for id: " + id));
    }

    public List<Ticket> getTickets(final Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found for id: " + eventId))
                .getTickets();
    }
}
