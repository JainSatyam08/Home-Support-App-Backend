package com.example.homesupportbackend.repository;

import com.example.homesupportbackend.entity.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelRequestRepository extends JpaRepository<Cancellation,String> {
    @Query(value = "SELECT nextval('cancellation_sequence')", nativeQuery = true)
    Long getNextCancellationSequence();
}
