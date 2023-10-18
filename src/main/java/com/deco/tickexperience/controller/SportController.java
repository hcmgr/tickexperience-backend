package com.deco.tickexperience.controller;
import com.deco.tickexperience.model.entity.Event;
import com.deco.tickexperience.model.entity.Sport;
import com.deco.tickexperience.model.entity.Video;
import com.deco.tickexperience.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/sport")
@RequiredArgsConstructor
public class SportController {

    final private SportService sportService;

    @GetMapping("/all")
    public List<Sport> getAllSports() {
        return sportService.getAllSports();
    }

    @GetMapping("/events/{sportId}")
    public List<Event> getEvents(@PathVariable Long sportId) {
        return sportService.getEvents(sportId);
    }
}