package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Section;
import com.deco.tickexperience.model.entity.Venue;
import com.deco.tickexperience.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;

    public Venue getVenue(final Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found for id: " + id));

    }

    public List<Section> getSections(final Long venueId) {
        List<Section> sections = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found for id: " + venueId))
                .getSections();
        sections.sort(Comparator.comparing(Section::getLocation));
        return sections;
    }
}
