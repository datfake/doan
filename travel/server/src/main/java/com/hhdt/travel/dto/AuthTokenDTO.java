package com.hhdt.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenDTO {
    private Long id;
    private String email;
    private String fullName;
    private String token;
}
