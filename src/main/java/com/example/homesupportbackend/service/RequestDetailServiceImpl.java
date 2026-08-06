package com.example.homesupportbackend.service;

import com.example.homesupportbackend.dto.RequestDetailDTO;
import com.example.homesupportbackend.entity.BookingRequest;
import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.entity.User;
import com.example.homesupportbackend.interfacial.RequestDetailService;
import com.example.homesupportbackend.repository.BookingRequestRepository;
import com.example.homesupportbackend.repository.BookingStatusRepository;
import com.example.homesupportbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RequestDetailServiceImpl implements RequestDetailService {
    private final UserRepository userRepository;
    private final BookingRequestRepository bookingRequestRepository;
    private final BookingStatusRepository bookingStatusRepository;

    public RequestDetailServiceImpl(UserRepository userRepository,
                                    BookingStatusRepository bookingStatusRepository,
                                    BookingRequestRepository bookingRequestRepository){
        this.bookingRequestRepository=bookingRequestRepository;
        this.userRepository=userRepository;
        this.bookingStatusRepository=bookingStatusRepository;
    }
    @Override
    public RequestDetailDTO getRequestDetail(String bookingId,String email){
        Optional<User> optionalUser=userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));


        Optional<BookingRequest> optionalBookingRequest=bookingRequestRepository.findById(bookingId);
        BookingRequest booking=optionalBookingRequest.orElseThrow(() -> new RuntimeException("Request Not Found"));
        if (!booking.getUser().getUserId().equals(user.getUserId())) {
            throw new RuntimeException("Unauthorized Access");
        }
        Optional<BookingStatus> optionalBookingStatus=bookingStatusRepository.findByBookingId(booking);
        BookingStatus bookingStatus=optionalBookingStatus.orElseThrow(() -> new RuntimeException("Request Not Found"));

        RequestDetailDTO dto=new RequestDetailDTO();

        dto.setBookingId(booking.getBookingId());
        dto.setStatus(bookingStatus.getStatus());
        dto.setAddress(booking.getAddressComplete());
        dto.setServiceType(booking.getServiceType());
        dto.setProblemDesc(booking.getProblemDesc());
        dto.setCustomerEmail(booking.getEmailId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setPrefDate(booking.getPreferredDate());
        dto.setPrefSlot(booking.getPreferredSlot());
        dto.setCustomerForCno(booking.getCFCno());
        dto.setCustomerForName(booking.getCFName());
        dto.setProblemType(booking.getProblemType());
        dto.setStatusUpdatedAt(bookingStatus.getStatusUpdateAt());

        return dto;

    }


}
