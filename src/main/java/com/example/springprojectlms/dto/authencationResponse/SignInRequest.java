package com.example.springprojectlms.dto.authencationResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SignInRequest {
    private String email;
    private String password;

}
