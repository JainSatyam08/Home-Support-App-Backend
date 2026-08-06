package com.example.homesupportbackend.interfacial;

import com.example.homesupportbackend.dto.RequestDetailDTO;

public interface RequestDetailService {
    RequestDetailDTO getRequestDetail(String bookingId,String email) throws RuntimeException;
}
