package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.config.JwtService;
import com.example.springprojectlms.dto.authencationResponse.AuthenticationResponse;
import com.example.springprojectlms.dto.authencationResponse.SignInRequest;
import com.example.springprojectlms.dto.authencationResponse.SignUpRequest;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.AuthenticationService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private  final PasswordEncoder passwordEncoder;
    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())){
            throw new EntityExistsException(String.format("user with email : %s already exists" + signUpRequest.getEmail()));
    }
        User user =User.builder().firstName(
                 signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .password(signUpRequest.getPassword())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .role(signUpRequest.getRole())
                .build();
        userRepository.save(user);
        String jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
     User user=   userRepository.getUserByEmail(signInRequest.getEmail()).orElseThrow(()->new EntityNotFoundException("user with email:"+signInRequest.getEmail()+""));
     if (signInRequest.getEmail().isBlank()){
         throw  new BadCredentialsException("email doesn't exists");
     }
     if (!passwordEncoder.matches(signInRequest.getPassword(),user.getPassword())){
         throw new BadCredentialsException("incorrect password!");

     }
   String jwtToken=  jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .token(jwtToken)
                .build();
    }
}
