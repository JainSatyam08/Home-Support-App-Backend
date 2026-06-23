package com.example.homesupportbackend.controller;

import com.example.homesupportbackend.dto.LoginRequest;
import com.example.homesupportbackend.entity.User;
import com.example.homesupportbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@RequestBody User user){

        userService.registerUser(user);

        return ResponseEntity.ok(
                new ApiResponse("User Registered Successfully")
        );
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }
}
