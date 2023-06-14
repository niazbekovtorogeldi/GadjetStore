package com.example.springprojectlms.dto.dtoUser;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;

import javax.management.relation.Role;
import java.time.ZonedDateTime;
@Builder
public record UserResponse(Long id,
                           String firstName,
                           String lastName,
                           String email,
                           String password
                           ) {
    public UserResponse {
    }
}
