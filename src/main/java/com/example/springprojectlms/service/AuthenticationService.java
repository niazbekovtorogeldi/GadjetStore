package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.authencationResponse.*;

public interface AuthenticationService {
    AuthenticationResponse adminToken(AdminTokenRequest adminTokenResponse);
    AuthenticationResponse signUp(AuthenticationRequest authenticationRequest);
    AuthenticationResponse signIn(SignInRequest signIn);


}
