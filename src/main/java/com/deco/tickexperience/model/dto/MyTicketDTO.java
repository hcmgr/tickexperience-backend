package com.deco.tickexperience.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MyTicketDTO {
    private Long ticketId;
    private LocalDateTime eventDateTime;
    private String eventName;
    private Long venueId;
    private String venueName;
    private String icon;
    private Integer seatNumber;
    private String qrCode;
    private List<String> videoUrls;
}

