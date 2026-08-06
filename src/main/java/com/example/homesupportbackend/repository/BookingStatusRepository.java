package com.example.homesupportbackend.repository;

import com.example.homesupportbackend.entity.BookingRequest;
import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus,Long> {
    List<BookingStatus> findByUserOrderByStatusUpdateAtDesc(User user);

    Optional<BookingStatus> findByBookingId(BookingRequest bookingRequest);
}
