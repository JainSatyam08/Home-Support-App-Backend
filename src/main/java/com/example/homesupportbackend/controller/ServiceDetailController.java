package com.example.homesupportbackend.controller;

import com.example.homesupportbackend.dto.RequestDetailDTO;
import com.example.homesupportbackend.interfacial.RequestDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/allService")
public class ServiceDetailController {
    private final RequestDetailService requestDetailService;
    public ServiceDetailController(RequestDetailService requestDetailService){
        this.requestDetailService= requestDetailService;
    }
    @GetMapping("/request-detail/{bookingId}")
    public ResponseEntity<RequestDetailDTO> getRequestDetail(
            @PathVariable String bookingId,
            Authentication authentication){
        String email= authentication.getName();
        return ResponseEntity.ok(requestDetailService.getRequestDetail(bookingId,email));
    }

}
