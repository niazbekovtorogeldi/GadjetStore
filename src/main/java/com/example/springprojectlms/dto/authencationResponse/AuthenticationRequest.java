package com.example.springprojectlms.dto.authencationResponse;

import com.example.springprojectlms.enam.Role;
import lombok.Builder;

@Builder
public record AuthenticationRequest(String firstName, String lastName, String email, String password,  Role role) {
    public AuthenticationRequest {
    }
}