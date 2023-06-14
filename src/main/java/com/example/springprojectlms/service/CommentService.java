package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoComment.CommentRequest;
import com.example.springprojectlms.dto.dtoComment.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {

    SimpleResponse saveComment(CommentRequest commentRequest,  Long productId);
    SimpleResponse deleteCommentById(Long id);
    SimpleResponse updateComment(Long id,CommentRequest commentRequest);
}
