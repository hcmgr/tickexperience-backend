package com.deco.tickexperience.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MyTicketDTO {
    private Long ticketId;
    private LocalDateTime eventDateTime;
    private String eventName;
    private String venueName;
    private String icon;
}

