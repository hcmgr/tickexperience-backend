package com.deco.tickexperience.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;

    @OneToMany(mappedBy ="event", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Event> events;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;


    public void addEvent(Event event) {
        event.setSession(this);
        if (this.getEvents() == null) {
            this.setEvents(new java.util.ArrayList<Event>());
        }
        this.getEvents().add(event);
    }

    public void addTicket(Ticket ticket) {
        ticket.setSession(this);
        if (this.getTickets() == null) {
            this.setTickets(new java.util.ArrayList<Ticket>());
        }
        this.getTickets().add(ticket);
    }
}
