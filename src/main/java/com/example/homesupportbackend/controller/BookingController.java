package com.example.homesupportbackend.controller;

import com.example.homesupportbackend.dto.BookingRequestDTO;
import com.example.homesupportbackend.dto.BookingResponseDTO;
import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.interfacial.BookingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookingResponseDTO> createBooking(
            @RequestBody BookingRequestDTO bookingRequestDTO,
            Authentication authentication
    ) {
        String email = authentication.getName();
        BookingResponseDTO response =
                bookingService.createBooking(bookingRequestDTO, email);

        return ResponseEntity.ok(response);


    }

}
