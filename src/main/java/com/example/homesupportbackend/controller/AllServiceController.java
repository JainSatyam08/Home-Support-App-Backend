package com.example.homesupportbackend.controller;

import com.example.homesupportbackend.dto.RequestSummaryDTO;
import com.example.homesupportbackend.service.AllRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;
import java.util.List;

@RestController
@RequestMapping("/api/allService")
public class AllServiceController {
    private final AllRequestService allRequestService;
    public AllServiceController(AllRequestService allRequestService){
        this.allRequestService=allRequestService;
    }

    @GetMapping("/requests")
    public ResponseEntity<List<RequestSummaryDTO>> getAllRequest(
            Authentication authentication){
        String email = authentication.getName();
        return ResponseEntity.ok(allRequestService.getAllRequests(email));
    }
}
