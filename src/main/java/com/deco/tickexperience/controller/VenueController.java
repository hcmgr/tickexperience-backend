package com.deco.tickexperience.controller;

import com.deco.tickexperience.model.entity.Venue;
import com.deco.tickexperience.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/venue-details")
public class VenueController {

    private final VenueService venueService;

    @GetMapping("/{venueId}")
    public Venue getVenueDetails(@PathVariable Long venueId) {
        return venueService.getVenueDetails(venueId);
    }
}
