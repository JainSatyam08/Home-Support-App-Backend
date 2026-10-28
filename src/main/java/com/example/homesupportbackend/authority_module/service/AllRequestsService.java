package com.example.homesupportbackend.authority_module.service;

import com.example.homesupportbackend.authentication_module.entity.auth_identity;
import com.example.homesupportbackend.authentication_module.repository.AuthIdentityRepositroy;
import com.example.homesupportbackend.authority_module.dto.AllRequestDTO;
import com.example.homesupportbackend.repository.BookingRequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AllRequestsService {

    private final AuthIdentityRepositroy authIdentityRepositroy;
    private final BookingRequestRepository bookingRequestRepository;
    public AllRequestsService(AuthIdentityRepositroy authIdentityRepositroy,BookingRequestRepository bookingRequestRepository){
        this.authIdentityRepositroy=authIdentityRepositroy;
        this.bookingRequestRepository=bookingRequestRepository;
    }

    public List<AllRequestDTO> getAllServices(String user_id) {

        Optional<auth_identity> optionalAuthIdentity =
                authIdentityRepositroy.findById(user_id);

        auth_identity AuthIdentity = optionalAuthIdentity.orElseThrow(
                () -> new RuntimeException("Unauthorised Access!!")
        );

        List<Object[]> completeList =
                bookingRequestRepository.getAllRequests();

        List<AllRequestDTO> finalList = new ArrayList<>();

        for (Object[] request : completeList) {

            AllRequestDTO dto = new AllRequestDTO();

            dto.setBookingId((String) request[0]);
            dto.setProblemDesc((String) request[1]);
            dto.setRoomNo((String) request[2]);
            dto.setServiceType((String) request[3]);
            dto.setLocation((String) request[4]);
            dto.setBookingStatus(
                    request[6] != null
                            ? request[6].toString()
                            : "Unknown"
            );

            finalList.add(dto);
        }

        return finalList;
    }

}
