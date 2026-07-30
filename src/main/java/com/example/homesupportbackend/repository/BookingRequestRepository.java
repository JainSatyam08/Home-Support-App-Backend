package com.example.homesupportbackend.repository;

import com.example.homesupportbackend.entity.BookingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRequestRepository extends JpaRepository<BookingRequest,String> {

    @Query(value = "SELECT nextval('booking_sequence')", nativeQuery = true)
    Long getNextBookingSequence();

}
