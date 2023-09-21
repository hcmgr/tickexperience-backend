package com.deco.tickexperience.controller;

import com.deco.tickexperience.model.entity.Event;
import com.deco.tickexperience.model.entity.Section;
import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable("id") Long id) {
        return eventService.getEvent(id);
    }

    @GetMapping("/tickets/{eventId}")
    public List<Ticket> getTickets(@PathVariable Long eventId) {
        return eventService.getNotBoughtTickets(eventId);
    }

    @GetMapping("/{eventId}/sections")
    public List<Section> getSections(@PathVariable Long eventId) {
        return eventService.getSections(eventId);
    }
}
