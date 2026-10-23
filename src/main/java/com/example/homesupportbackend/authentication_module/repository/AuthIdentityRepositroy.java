package com.example.homesupportbackend.authentication_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.homesupportbackend.authentication_module.entity.auth_identity;

import java.util.Optional;

public interface AuthIdentityRepositroy extends JpaRepository<auth_identity,String> {
    Optional<auth_identity> findByEmail(String email);
    Optional<auth_identity> findById(String userId);
    Optional<auth_identity> findByPhone(String phone);
    boolean existsByEmail(String email);//is email exists or  not ask to the database
    boolean existsByPhone(String phone);
}
