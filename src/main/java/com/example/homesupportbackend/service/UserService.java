package com.example.homesupportbackend.service;

import com.example.homesupportbackend.dto.LoginRequest;
import com.example.homesupportbackend.entity.User;
import com.example.homesupportbackend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    public void registerUser(User user){

        if(userRepository.existsByEmail(user.getEmail())){ //getEmail function written in User.java
            //existsByEmail function in UserRepository.java
            // if true gives exception
            throw new RuntimeException("Email already registered");
        }

        if(userRepository.existsByPhone(user.getPhone())){
            throw new RuntimeException("Phone already registered");
        }
        String hashedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);

        user.setEmailVerified(false);
        user.setPhoneVerified(false);
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        userRepository.save(user);

    }

    public String loginUser(LoginRequest loginRequest){
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        if(user.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User existingUser = user.get();

        if(!passwordEncoder.matches(
                loginRequest.getPassword(),
                existingUser.getPasswordHash()
        )){
            throw new RuntimeException("Invalid Password");
        }

        return "Login Successful";
    }
}
