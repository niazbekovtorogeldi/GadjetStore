package com.example.springprojectlms.api;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoUser.UserRequest;
import com.example.springprojectlms.dto.dtoUser.UserResponse;
import com.example.springprojectlms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;
    @GetMapping("/getAll")
    public List<UserResponse>getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public SimpleResponse save(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);

    }
    @PostMapping("/update")
    public SimpleResponse update(@PathVariable Long id,@RequestBody UserRequest userRequest){
        return userService.updateUser(id,userRequest);
    }
    @GetMapping("/getById")
    public UserResponse getById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/deleted")
    public SimpleResponse deletedUser(Long id){
        return userService.deleteUserById(id);

    }

}
