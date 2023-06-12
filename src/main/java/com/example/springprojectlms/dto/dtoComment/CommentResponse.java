package com.example.springprojectlms.dto.dtoComment;

import lombok.Builder;

import java.time.ZonedDateTime;
@Builder
public record CommentResponse (Long id,String comment,ZonedDateTime createDate){
    public CommentResponse {
    }
}
