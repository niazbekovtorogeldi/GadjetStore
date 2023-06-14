package com.example.springprojectlms.repository;

import com.example.springprojectlms.dto.dtoComment.CommentResponse;
import com.example.springprojectlms.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
//    @Modifying
//    @Query("select new peaksoft.dto.dtoComment.CommentResponse(c.id,c.comment,c.createdAt) from Comment c ")
//    List<CommentResponse> getAllUserComments();
}
