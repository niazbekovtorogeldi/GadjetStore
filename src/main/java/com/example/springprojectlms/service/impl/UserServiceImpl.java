package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoUser.UserRequest;
import com.example.springprojectlms.dto.dtoUser.UserResponse;
import com.example.springprojectlms.entity.Product;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public SimpleResponse saveUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setRole(user.getRole());
        user.setPassword(userRequest.password());
        userRepository.save(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }

    @Override
    public SimpleResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(()->new NullPointerException(""));
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setRole(user.getRole());
        userRepository.save(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepository.findProductById(id).orElseThrow(()->new NullPointerException(""));
    }

    @Override
    public SimpleResponse deleteUserById(Long id) {
       User user = userRepository.findById(id).orElseThrow(()-> new NullPointerException(""));
       userRepository.delete(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();

    }
}
