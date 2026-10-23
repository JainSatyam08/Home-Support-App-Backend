package com.example.homesupportbackend.authentication_module.repository;

import com.example.homesupportbackend.authentication_module.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<employee,String> {
    @Query(value = "SELECT nextval('emp_id')", nativeQuery = true)
    Long getNextEmployeeSequence();


    Optional<employee> findById(String emp_id);
}
