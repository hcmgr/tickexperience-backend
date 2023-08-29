package com.deco.tickexperience.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ActiveUser {
    private Long userId;
    private LocalDateTime lastActiveTime;
}
