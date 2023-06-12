package com.example.springprojectlms.dto.authencationResponse;

import com.example.springprojectlms.enam.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
@Builder
@Data
@AllArgsConstructor
public class SignUpRequest {
    private  Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Role role;
    private String email;
}
