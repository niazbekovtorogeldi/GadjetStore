package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoComment.CommentRequest;
import com.example.springprojectlms.entity.Brand;
import com.example.springprojectlms.entity.Comment;
import com.example.springprojectlms.repository.CommentRepository;
import com.example.springprojectlms.repository.ProductRepository;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;


    @Override
    public SimpleResponse saveComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setCommentName(comment.getCommentName());
        commentRepository.save(comment);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }

    @Override
    public SimpleResponse deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(()->
                new NullPointerException("not"));
        commentRepository.delete(comment);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();

    }
}
