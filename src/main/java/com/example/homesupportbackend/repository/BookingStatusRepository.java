package com.example.homesupportbackend.repository;

import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus,Long> {
    List<BookingStatus> findByUserOrderByStatusUpdateAtDesc(User user);
}
