package com.deco.tickexperience.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    public void addEvent(Event event) {
        event.setSport(this);
        if (this.getEvents() == null) {
            this.setEvents(new java.util.ArrayList<Event>());
        }
        this.getEvents().add(event);
    }
}
