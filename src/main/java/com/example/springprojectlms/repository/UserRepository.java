package com.example.springprojectlms.repository;

import com.example.springprojectlms.dto.dtoUser.UserResponse;
import com.example.springprojectlms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select new com.example.springprojectlms.dto.dtoUser.UserResponse(u.firstName,u.lastName,u.role,u.password) from User u")
    List<UserResponse> getAllUsers();
}
