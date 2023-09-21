package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Event;
import com.deco.tickexperience.model.entity.Section;
import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event getEvent(final Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found for id: " + id));
    }

    public List<Ticket> getNotBoughtTickets(final Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found for id: " + eventId))
                .getTickets()
                .stream()
                .filter(ticket -> ticket.getUser() == null)
                .collect(Collectors.toList());
    }

    public List<Section> getSections(final Long eventId) {

        List<Section> sections = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found for id: " + eventId))
                .getVenue()
                .getSections();

        sections.sort(Comparator.comparing(Section::getLocation));
        return sections;
    }
}
