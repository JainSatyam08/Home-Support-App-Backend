package com.example.homesupportbackend.repository;

import com.example.homesupportbackend.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus,Long> {
}
