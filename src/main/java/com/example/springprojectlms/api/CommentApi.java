package com.example.springprojectlms.api;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoComment.CommentRequest;
import com.example.springprojectlms.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentApi {
private final CommentService commentService;
    @PostMapping
    public SimpleResponse saveComment(@RequestBody CommentRequest commentRequest, @RequestParam Long productId){
        return commentService.saveComment(commentRequest,productId);
    }
    @DeleteMapping("/{id}")
    public SimpleResponse deleted(@PathVariable Long id){
        return commentService.deleteCommentById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@PathVariable Long id,@RequestBody CommentRequest commentRequest){
        return commentService.updateComment(id,commentRequest);
    }

}
