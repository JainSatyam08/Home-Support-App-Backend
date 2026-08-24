package com.example.homesupportbackend.service;

import com.example.homesupportbackend.dto.CancelRequestDTO;
import com.example.homesupportbackend.dto.CancelResponseDTO;
import com.example.homesupportbackend.entity.BookingRequest;
import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.entity.Cancellation;
import com.example.homesupportbackend.entity.User;
import com.example.homesupportbackend.interfacial.CancelService;
import com.example.homesupportbackend.repository.BookingRequestRepository;
import com.example.homesupportbackend.repository.BookingStatusRepository;
import com.example.homesupportbackend.repository.CancelRequestRepository;
import com.example.homesupportbackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Optional;

@Service
@Transactional
public class CancelRequestServiceImpl implements CancelService {
    private final UserRepository userRepository;
    private final BookingRequestRepository bookingRequestRepository;
    private final BookingStatusRepository bookingStatusRepository;
    private final CancelRequestRepository cancelRequestRepository;

    public CancelRequestServiceImpl(
            UserRepository userRepository,
            BookingRequestRepository bookingRequestRepository,
            BookingStatusRepository bookingStatusRepository,
            CancelRequestRepository cancelRequestRepository

    ){
        this.bookingRequestRepository=bookingRequestRepository;
        this.bookingStatusRepository=bookingStatusRepository;
        this.userRepository=userRepository;
        this.cancelRequestRepository=cancelRequestRepository;
    }

    private String generateCancelId() {
        Long sequence = cancelRequestRepository.getNextCancellationSequence();
        String year = String.valueOf(Year.now().getValue());
        String formattedSequence = String.format("%06d", sequence);
        //String serviceCode = getServiceCode(serviceType);

        return "HS-" + "CNL"+ "-" + year + "-" + formattedSequence;
    }

    @Override
    public CancelResponseDTO cancelBooking(CancelRequestDTO cancelRequestDTO, String email, String bookingId){
        Optional<User> optionalUser=userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        Optional<BookingRequest> optionalBookingRequest=bookingRequestRepository.findById(bookingId);
        BookingRequest bookingRequest=optionalBookingRequest.orElseThrow(()-> new RuntimeException("Booking Not Found"));
        if (!bookingRequest.getUser().getUserId().equals(user.getUserId())) {
            throw new RuntimeException("Unauthorized Access");
        }
        Optional<BookingStatus> optionalBookingStatus=bookingStatusRepository.findByBookingId(bookingRequest);
        BookingStatus bookingstatus=optionalBookingStatus.orElseThrow(()-> new RuntimeException("Booking Not Found"));
        if (bookingstatus.getStatus().equals("Cancelled")) {
            throw new RuntimeException("Booking is already cancelled");
        }
        bookingstatus.setStatus("Cancelled");
        bookingStatusRepository.save(bookingstatus);
        Cancellation cancel=new Cancellation();
        cancel.setBookingId(bookingRequest);
        cancel.setUser(user);
        cancel.setBookingDate(bookingRequest.getBookingDate());
        cancel.setCancelTime(LocalDateTime.now());
        cancel.setReason(cancelRequestDTO.getReason());
        cancel.setLatitude(cancelRequestDTO.getLatitude());
        cancel.setLongitude(cancelRequestDTO.getLongitude());
        String cancelId = generateCancelId();
        cancel.setCancel_id(cancelId);


        Cancellation savedCancellation =
                cancelRequestRepository.save(cancel);

        CancelResponseDTO response=new CancelResponseDTO();

        response.setCancelId(savedCancellation.getCancel_id());
        response.setCancelled_by(user.getFullName());
        response.setServiceType(bookingRequest.getServiceType());
        response.setReason(savedCancellation.getReason());
        response.setBookingId(bookingRequest.getBookingId());

        return response;
    }

}
