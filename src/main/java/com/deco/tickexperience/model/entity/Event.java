package com.deco.tickexperience.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String gender;
    private String imageURL;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SportId")
    private Sport sport;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="VenueId")
    private Venue venue;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;

    public void addTicket(Ticket ticket) {
        ticket.setEvent(this);
        if (this.getTickets() == null) {
            this.setTickets(new java.util.ArrayList<>());
        }
        this.getTickets().add(ticket);
    }
}
