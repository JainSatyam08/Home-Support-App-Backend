package com.example.homesupportbackend.authority_module.controller;

import com.example.homesupportbackend.authority_module.dto.AllRequestDTO;
import com.example.homesupportbackend.authority_module.service.AllRequestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auth/employee")
public class AllRequestsController {
    private final AllRequestsService allRequestsService;
    public AllRequestsController(AllRequestsService allRequestsService){
        this.allRequestsService=allRequestsService;
    }
    @GetMapping("/allservice")
    public ResponseEntity<List<AllRequestDTO>> getAllService(
            Authentication authentication
    ){
        String user_id=authentication.getName();
        return ResponseEntity.ok(allRequestsService.getAllServices(user_id));

    }
}
