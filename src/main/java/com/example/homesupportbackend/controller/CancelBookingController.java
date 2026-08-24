package com.example.homesupportbackend.controller;

import com.example.homesupportbackend.dto.CancelRequestDTO;
import com.example.homesupportbackend.dto.CancelResponseDTO;
import com.example.homesupportbackend.interfacial.CancelService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class CancelBookingController {
    private final CancelService cancelService;

    public CancelBookingController(CancelService cancelService){
        this.cancelService=cancelService;
    }
    @DeleteMapping("/{bookingId}/cancel")
    public ResponseEntity<CancelResponseDTO> cancelBooking(
            @PathVariable String bookingId,
            @RequestBody CancelRequestDTO cancelRequestDTO,
            Authentication authentication
            ){
        String email=authentication.getName();
        return ResponseEntity.ok(cancelService.cancelBooking(cancelRequestDTO,email,bookingId));
    }

}
