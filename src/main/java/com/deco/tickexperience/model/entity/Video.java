package com.deco.tickexperience.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String videoUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SportId")
    @JsonIgnore
    private Sport sport;
}
