package com.example.homesupportbackend.controller;

import com.example.homesupportbackend.dto.ApiResponse;
import com.example.homesupportbackend.dto.LoginRequest;
import com.example.homesupportbackend.dto.LoginResponse;
import com.example.homesupportbackend.entity.User;
import com.example.homesupportbackend.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profile(Authentication authentication) {
        return ResponseEntity.ok(
                "Logged in as: " + authentication.getName()
        );
    }
}
