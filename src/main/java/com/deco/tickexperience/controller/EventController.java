package com.deco.tickexperience.controller;

import com.deco.tickexperience.model.entity.Event;
import com.deco.tickexperience.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${apiAuthedPrefix}/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable("id") Long id, @RequestHeader("token") String token) {
        return eventService.getEvent(id);
    }
}
