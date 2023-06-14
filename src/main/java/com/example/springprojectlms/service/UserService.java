package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoUser.UserRequest;
import com.example.springprojectlms.dto.dtoUser.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();
    SimpleResponse saveUser(UserRequest userRequest);
    SimpleResponse updateUser(Long id, UserRequest userRequest);
    UserResponse getUserById(Long id);
    SimpleResponse deleteUserById(Long id);
}
