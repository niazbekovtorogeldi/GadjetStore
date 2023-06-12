package com.example.springprojectlms.dto.dtoComment;

import lombok.Builder;

import java.time.ZonedDateTime;
@Builder
public record CommentRequest( String comment) {
    public CommentRequest {
    }
}
