package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.config.JwtService;
import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoComment.CommentRequest;
import com.example.springprojectlms.entity.Brand;
import com.example.springprojectlms.entity.Comment;
import com.example.springprojectlms.entity.Product;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.CommentRepository;
import com.example.springprojectlms.repository.ProductRepository;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {


    private final CommentRepository repository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final JwtService jwtService;



    private User getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.getUserByEmail(email).orElseThrow(() -> new NullPointerException("User with email:" + email + " is not found!"));
        return user;
    }

    @Override
    public SimpleResponse saveComment(CommentRequest commentRequest,  Long productId) {
        User user=jwtService.getAuthentication();
        Product product = productRepository.findById(productId).orElseThrow(() -> new NullPointerException("Product with id:" + productId + " is not found!"));
        List<Product> products = new ArrayList<>();
        products.add(product);
        Comment comment = new Comment();
        comment.setCommentName(commentRequest.comment());
        comment.setCreateDate(ZonedDateTime.now());
        comment.setUser(user);
        comment.setProducts(products);
        repository.save(comment);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("The comment successfully saved")
                .build();
    }

    @Override
    public SimpleResponse deleteCommentById(Long id) {
        Comment comment = repository.findById(id).orElseThrow(() -> new NullPointerException("Comment is not found"));
        if (repository.existsById(id)) {
            comment.getUser().getComments().remove(comment);
            for (Product p : comment.getProducts()) {
                if (p.getComment().equals(comment)) {
                    p.setComment(null);
                }
            }
            repository.deleteById(id);
        }
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Successfully deleted")
                .build();
    }

    @Override
    public SimpleResponse updateComment(Long id, CommentRequest commentRequest) {
        Comment comment = repository.findById(id).orElseThrow(() -> new NullPointerException("Comment is not found"));
        User user =jwtService.getAuthentication();
        if (comment.getUser().equals(user)){
            comment.setCommentName(commentRequest.comment());
            repository.save(comment);
            return SimpleResponse.builder()
                    .status(HttpStatus.OK)
                    .message("Successfully updated")
                    .build();
        }else throw new NullPointerException("Comment is empty");

    }
}