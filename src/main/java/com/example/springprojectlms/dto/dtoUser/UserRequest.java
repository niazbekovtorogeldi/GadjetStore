package com.example.springprojectlms.dto.dtoUser;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;

import javax.management.relation.Role;
import java.time.ZonedDateTime;
@Builder
public record UserRequest(String firstName,
                          String lastName,
                          String password,
                          Role role) {
    public UserRequest {
    }
}
