package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.config.JwtService;
import com.example.springprojectlms.dto.authencationResponse.*;
import com.example.springprojectlms.enam.Role;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.AuthenticationService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse adminToken(AdminTokenRequest adminTokenRequest) {
        // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.email(),authenticationRequest.password()));
//        User user = userRepository.getUserByEmail(adminTokenRequest.email()).orElseThrow(() -> new UsernameNotFoundException("user with email: " +adminTokenRequest.email()  + " is not found!"));
        User user1 = userRepository.findById(1L).orElseThrow(() -> new UsernameNotFoundException("user with email: 1 is not found!"));
        String token = jwtService.generateToken(user1);
        System.out.println(token);
        return AuthenticationResponse.builder()
                .email(user1.getEmail())
                .token(token)
                .role(user1.getRole())
                .build();
    }

    @Override
    public AuthenticationResponse signUp(AuthenticationRequest authenticationRequest) {
        if (userRepository.existsByEmail(authenticationRequest.email())){
            throw new  EntityExistsException("user with email: "+ authenticationRequest.email()+" already exist");
        }
        User user = new User();
        user.setFirstName(authenticationRequest.firstName());
        user.setLastName(authenticationRequest.lastName());
        user.setEmail(authenticationRequest.email());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(authenticationRequest.password()));
        user.setCreateAt(ZonedDateTime.now());
        user.setUpdateDate(ZonedDateTime.now());
        userRepository.save(user);
        String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .role(user.getRole())
                .email(user.getEmail())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signIn) {
        User user = userRepository.getUserByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user is not found"));
        if (signIn.getPassword().isBlank()){
            throw new BadCredentialsException("email does not exist...");
        }
        if (!passwordEncoder.matches(signIn.getPassword(), user.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }
        String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .role(user.getRole())
                .email(user.getEmail())
                .build();
    }
    @PostConstruct
    public  void init(){
        User user = new User();
        user.setFirstName("torogeldi");
        user.setLastName("nizbekov");
        user.setPassword(passwordEncoder.encode("torogeldi123"));
        user.setEmail("t@gmail.com");
        user.setRole(Role.ADMIN);
        user.setCreateAt(ZonedDateTime.now());
        user.setUpdateDate(ZonedDateTime.now());
        if (!userRepository.existsByEmail(user.getEmail())){
            userRepository.save(user);
        }
    }
}
