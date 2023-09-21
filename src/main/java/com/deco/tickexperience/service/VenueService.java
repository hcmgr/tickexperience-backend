package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Venue;
import com.deco.tickexperience.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;

    public Venue getVenue(final Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found for id: " + id));

    }
}
