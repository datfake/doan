package com.hhdt.travel.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;

    private String email;

    private String fullName;

    private String password;
}
