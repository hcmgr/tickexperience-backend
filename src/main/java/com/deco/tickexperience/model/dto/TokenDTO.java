package com.deco.tickexperience.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO to pass user auth token.
 */
@AllArgsConstructor
@Data
public class TokenDTO {

    private String token;
}
