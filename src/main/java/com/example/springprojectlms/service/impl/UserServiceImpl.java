package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.config.JwtService;
import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoUser.UserRequest;
import com.example.springprojectlms.dto.dtoUser.UserResponse;
import com.example.springprojectlms.enam.Role;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.BasketRepository;
import com.example.springprojectlms.repository.FavoriteRepository;
import com.example.springprojectlms.repository.ProductRepository;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        user.setRole(Role.USER);
        user.setPassword(userRequest.password());
        userRepository.save(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("")
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
                .message("")
                .build();
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepository.findUserById(id).orElseThrow(()->new NullPointerException(""));

    }

    @Override
    public SimpleResponse deleteUserById(Long id) {
       User user = userRepository.findById(id).orElseThrow(()-> new NullPointerException(""));
       userRepository.delete(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("")
                .build();

    }
}
