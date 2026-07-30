package com.example.homesupportbackend.service;

import com.example.homesupportbackend.dto.BookingRequestDTO;
import com.example.homesupportbackend.dto.BookingResponseDTO;
import com.example.homesupportbackend.entity.BookingRequest;
import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.entity.User;
import com.example.homesupportbackend.interfacial.BookingService;
import com.example.homesupportbackend.repository.BookingRequestRepository;
import com.example.homesupportbackend.repository.BookingStatusRepository;
import com.example.homesupportbackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final BookingRequestRepository bookingRequestRepository;
    private final BookingStatusRepository bookingStatusRepository;


    public BookingServiceImpl(UserRepository userRepository,
                              BookingRequestRepository bookingRequestRepository,
                              BookingStatusRepository bookingStatusRepository){
        this.userRepository=userRepository;
        this.bookingRequestRepository = bookingRequestRepository;
        this.bookingStatusRepository = bookingStatusRepository;
    }
    private String getServiceCode(String serviceType){


            switch (serviceType.toLowerCase()) {

                case "electrician":{
                    return "EL";}

                case "plumbing":{
                    return "PL";}

                case "carpenter":{
                    return "CP";}

                case "cleaning":{
                    return "CL";}

                case "ac repair":{
                    return "AC";}

                case "appliance repair":
                    return "AR";

                case "painting":
                    return "PT";

                default:
                    return "OT";
            }

    }
    private String generateBookingId(String serviceType) {
        Long sequence = bookingRequestRepository.getNextBookingSequence();
        String year = String.valueOf(Year.now().getValue());
        String formattedSequence = String.format("%06d", sequence);
        String serviceCode = getServiceCode(serviceType);

        return "HS-" + serviceCode + "-" + year + "-" + formattedSequence;
    }

    @Transactional
    @Override
    public BookingResponseDTO createBooking(
            BookingRequestDTO bookingRequestDTO,
            String email){
        Optional<User> optionalUser=userRepository.findByEmail(email);

        User user= optionalUser.orElseThrow(() -> new RuntimeException("User Not Found"));
        BookingRequest bookingRequest=new BookingRequest();


        bookingRequest.setUser(user);
        bookingRequest.setCname(user.getFullName());
        bookingRequest.setCno(user.getPhone());
        bookingRequest.setEmailId(user.getEmail());
        bookingRequest.setCFName(user.getFullName());
        bookingRequest.setCFCno(user.getPhone());
        bookingRequest.setLatitude(bookingRequestDTO.getLatitude());
        bookingRequest.setLongitude(bookingRequestDTO.getLongitude());
        bookingRequest.setServiceType(bookingRequestDTO.getServiceType());
        bookingRequest.setPreferredDate(bookingRequestDTO.getPreferredDate());
        bookingRequest.setPreferredSlot(bookingRequestDTO.getPreferredSlot());
        bookingRequest.setProblemDesc(bookingRequestDTO.getProblemDesc());
        bookingRequest.setProblemType(bookingRequestDTO.getProblemType());
        bookingRequest.setAddressComplete(bookingRequestDTO.getAddressComplete());
        String bookingId = generateBookingId(bookingRequestDTO.getServiceType());

        bookingRequest.setBookingId(bookingId);
        bookingRequest.setBookingDate(LocalDate.now());

        BookingRequest savedBooking =
                bookingRequestRepository.save(bookingRequest);


        BookingStatus bookingStatus=new BookingStatus();
        bookingStatus.setUser(user);
        bookingStatus.setBookingRequest(savedBooking);
        bookingStatus.setServiceType(savedBooking.getServiceType());

        bookingStatus.setCname(savedBooking.getCname());
        bookingStatus.setCno(savedBooking.getCno());
        bookingStatus.setAddressComplete(savedBooking.getAddressComplete());
        bookingStatus.setStatus("Pending");
        BookingStatus savedStatus =
                bookingStatusRepository.save(bookingStatus);

        BookingResponseDTO response=new BookingResponseDTO();
        response.setBookingId(savedBooking.getBookingId());
        response.setMessage("User Register Successfully");
        response.setCname(savedBooking.getCname());
        response.setTrackId(savedStatus.getTrackId());
        response.setServiceType(savedBooking.getServiceType());
        response.setStatus(savedStatus.getStatus());
        response.setCno(savedBooking.getCno());

        return response;

    }
}
