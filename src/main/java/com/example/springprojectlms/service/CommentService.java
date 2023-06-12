package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoComment.CommentRequest;
import org.springframework.stereotype.Service;


public interface CommentService {
    SimpleResponse saveComment(CommentRequest commentRequest);
    SimpleResponse deleteCommentById(Long id);
}
