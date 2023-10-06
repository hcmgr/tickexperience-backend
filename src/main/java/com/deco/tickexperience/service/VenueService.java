package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Venue;
import com.deco.tickexperience.model.entity.VenueImage;
import com.deco.tickexperience.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;

    public Venue getVenue(final Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found for id: " + id));
    }

    public List<String> getVenueImages(final Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found for id: " + id))
                .getImageUrls()
                .stream()
                .map(VenueImage::getImageUrl)
                .collect(Collectors.toList());
    }
}
