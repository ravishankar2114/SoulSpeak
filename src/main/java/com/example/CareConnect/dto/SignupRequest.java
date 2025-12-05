package com.example.CareConnect.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SignupRequest {
    private String name;
    private String email;
    private String password;
    private String role;
}

