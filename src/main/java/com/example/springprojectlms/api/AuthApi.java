package com.example.springprojectlms.api;

import com.example.springprojectlms.dto.authencationResponse.AdminTokenRequest;
import com.example.springprojectlms.dto.authencationResponse.AuthenticationRequest;
import com.example.springprojectlms.dto.authencationResponse.AuthenticationResponse;
import com.example.springprojectlms.dto.authencationResponse.SignInRequest;
import com.example.springprojectlms.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthApi {
    private final AuthenticationService service;

    @PostMapping
    public AuthenticationResponse getAdminToken(AdminTokenRequest adminTokenResponse){
        return service.adminToken(adminTokenResponse);
    }

    @PostMapping("/singUp")
    public AuthenticationResponse signUp(@RequestBody AuthenticationRequest authenticationRequest){
        return service.signUp(authenticationRequest);
    }
    @PostMapping("/signIn")
    public AuthenticationResponse signIn(@RequestBody SignInRequest signIn){
        return service.signIn(signIn);
    }
}
