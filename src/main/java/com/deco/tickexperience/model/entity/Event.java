package com.deco.tickexperience.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SessionId")
    private Session session;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SportId")
    private Sport sport;
}
