package com.deco.tickexperience.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String userSalt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;

    public void addTicket(Ticket ticket) {
        ticket.setUser(this);
        if (this.getTickets() == null) {
            this.setTickets(new ArrayList<Ticket>());
        }
        this.getTickets().add(ticket);
    }
}
