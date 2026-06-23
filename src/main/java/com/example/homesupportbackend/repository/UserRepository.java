package com.example.homesupportbackend.repository;

import com.example.homesupportbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(String phone);

    boolean existsByEmail(String email);//is email exists or  not ask to the database
    //use in UserService.java

    boolean existsByPhone(String phone);

}
