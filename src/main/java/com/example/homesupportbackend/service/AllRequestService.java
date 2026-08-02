package com.example.homesupportbackend.service;

import com.example.homesupportbackend.dto.RequestSummaryDTO;
import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.entity.User;
import com.example.homesupportbackend.repository.BookingStatusRepository;
import com.example.homesupportbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AllRequestService {
    private final UserRepository userRepository;
    private final BookingStatusRepository bookingStatusRepository;

    public AllRequestService( UserRepository userRepository,BookingStatusRepository bookingStatusRepository){
        this.bookingStatusRepository=bookingStatusRepository;
        this.userRepository=userRepository;
    }

    public List<RequestSummaryDTO> getAllRequests(String email) {

        Optional<User> optionalUser=userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        List<BookingStatus> bookingStatusList = bookingStatusRepository.findByUserOrderByStatusUpdateAtDesc(user);

        List<RequestSummaryDTO> requestSummaryList = new ArrayList<>();
        for (BookingStatus bookingStatus : bookingStatusList) {
            RequestSummaryDTO dto = new RequestSummaryDTO();
            dto.setBookingId(
                    bookingStatus.getBookingRequest().getBookingId()
            );
            dto.setTrackId(bookingStatus.getTrackId());
            dto.setServiceType(bookingStatus.getServiceType());
            dto.setStatus(bookingStatus.getStatus());
            dto.setStatusUpdatedAt(bookingStatus.getStatusUpdateAt().toLocalDate());

            requestSummaryList.add(dto);

        }
        return requestSummaryList;

    }
}
