package com.deco.tickexperience.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String icon;

    @OneToMany(mappedBy = "sport")
    @JsonIgnore
    private List<Event> events;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Video> videoUrls;

    public void addEvent(Event event) {
        event.setSport(this);
        if (this.getEvents() == null) {
            this.setEvents(new java.util.ArrayList<Event>());
        }
        this.getEvents().add(event);
    }
}
