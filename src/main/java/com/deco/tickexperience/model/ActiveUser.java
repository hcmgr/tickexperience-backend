package com.deco.tickexperience.model;

import com.deco.tickexperience.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ActiveUser {
    private Long userId; // may be better to just store name and pull from db
    private LocalDateTime lastActiveTime;
}
