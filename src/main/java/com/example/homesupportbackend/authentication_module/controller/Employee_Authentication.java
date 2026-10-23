package com.example.homesupportbackend.authentication_module.controller;


import com.example.homesupportbackend.authentication_module.Service.EmployeeAuthService;
import com.example.homesupportbackend.authentication_module.dto.EmployeeLogInRequestDTO;
import com.example.homesupportbackend.authentication_module.dto.EmployeeLoginResponseDTO;
import com.example.homesupportbackend.authentication_module.dto.EmployeeSignUpRequestDTO;
import com.example.homesupportbackend.authentication_module.dto.EmployeeSignUpResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/employee")
public class Employee_Authentication {


    EmployeeAuthService emp_service;
    public Employee_Authentication(EmployeeAuthService emp_service){
        this.emp_service=emp_service;
    }

    @PostMapping("/signup")
    public ResponseEntity<EmployeeSignUpResponseDTO> signup(@RequestBody EmployeeSignUpRequestDTO signup){
        EmployeeSignUpResponseDTO response= emp_service.registerEmployee(signup);
        return ResponseEntity.ok( response);

    }

    @PostMapping("/login")
    public ResponseEntity<EmployeeLoginResponseDTO> login(@RequestBody EmployeeLogInRequestDTO login){

        return ResponseEntity.ok(emp_service.loginEmployee(login));
    }
}
