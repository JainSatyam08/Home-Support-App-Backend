package com.example.homesupportbackend.authority_module.controller;

import com.example.homesupportbackend.authority_module.dto.AllEmployeeDTO;
import com.example.homesupportbackend.authority_module.dto.AllRequestDTO;
import com.example.homesupportbackend.authority_module.service.AllEmployeeService;
import com.example.homesupportbackend.authority_module.service.AllRequestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("auth/employee")
public class AllEmployeeController {
    private final AllEmployeeService allEmployeeService;
    public AllEmployeeController(AllEmployeeService allEmployeeService){

        this.allEmployeeService=allEmployeeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<AllEmployeeDTO>> getAllService(
            Authentication authentication
    ){
        String user_id=authentication.getName();
        return ResponseEntity.ok(allEmployeeService.getAllEmployees(user_id));

    }
}
