package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.authencationResponse.AuthenticationResponse;
import com.example.springprojectlms.dto.authencationResponse.SignInRequest;
import com.example.springprojectlms.dto.authencationResponse.SignUpRequest;

public interface AuthenticationService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);
    AuthenticationResponse signIn(SignInRequest signInRequest);
}
