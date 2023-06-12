package com.example.springprojectlms.dto.authencationResponse;

import com.example.springprojectlms.enam.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    private Long id;
    private String token;
    private String email;
    private Role role;
}
