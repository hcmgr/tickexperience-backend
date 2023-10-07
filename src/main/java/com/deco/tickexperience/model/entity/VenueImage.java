package com.deco.tickexperience.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VenueImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="VenueId")
    @JsonIgnore
    private Venue venue;
}