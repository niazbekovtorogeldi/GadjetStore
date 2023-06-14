package com.example.springprojectlms.dto.authencationResponse;

import lombok.Builder;

@Builder
public record AdminTokenRequest(String email) {
    public AdminTokenRequest {
    }
}
