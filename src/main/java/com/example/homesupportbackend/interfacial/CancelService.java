package com.example.homesupportbackend.interfacial;

import com.example.homesupportbackend.dto.CancelRequestDTO;
import com.example.homesupportbackend.dto.CancelResponseDTO;

public interface CancelService {
    CancelResponseDTO cancelBooking(CancelRequestDTO cancelRequestDTO,String email,String bookingId);
}
