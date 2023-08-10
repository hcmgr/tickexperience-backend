package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Event;
import com.deco.tickexperience.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event getEvent(final Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found for id: " + id));
    }
}
