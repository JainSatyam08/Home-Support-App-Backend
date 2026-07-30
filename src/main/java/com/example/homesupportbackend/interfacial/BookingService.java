package com.example.homesupportbackend.interfacial;

import com.example.homesupportbackend.dto.BookingRequestDTO;
import com.example.homesupportbackend.dto.BookingResponseDTO;

public interface BookingService {
    BookingResponseDTO createBooking(
            BookingRequestDTO bookingRequestDTO,
            String email
    );
}
