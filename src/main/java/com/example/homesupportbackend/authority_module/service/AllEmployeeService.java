package com.example.homesupportbackend.authority_module.service;

import com.example.homesupportbackend.authentication_module.entity.auth_identity;

import com.example.homesupportbackend.authentication_module.entity.employee;
import com.example.homesupportbackend.authentication_module.repository.AuthIdentityRepositroy;
import com.example.homesupportbackend.authentication_module.repository.EmployeeRepository;
import com.example.homesupportbackend.authority_module.dto.AllEmployeeDTO;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AllEmployeeService {
    private final AuthIdentityRepositroy authIdentityRepositroy;
    private final EmployeeRepository employeeRepository;
    public AllEmployeeService(AuthIdentityRepositroy authIdentityRepositroy,EmployeeRepository employeeRepository){
        this.authIdentityRepositroy=authIdentityRepositroy;
        this.employeeRepository=employeeRepository;
    }

    public List<AllEmployeeDTO> getAllEmployees(String user_id) {

        Optional<auth_identity> optionalAuthIdentity =
                authIdentityRepositroy.findById(user_id);

        auth_identity authIdentity = optionalAuthIdentity.orElseThrow(
                () -> new RuntimeException("Unauthorised Access!!")
        );

        List<employee> employeeList = employeeRepository.findAll();

        List<AllEmployeeDTO> finalList = new ArrayList<>();

        for (employee employee : employeeList) {

            AllEmployeeDTO dto = new AllEmployeeDTO();

            dto.setEmp_id(employee.getEmp_id());
            dto.setEmp_name(employee.getEmp_name());
            dto.setEmail(employee.getEmail());
            dto.setPhone(employee.getPhone());
            dto.setRole(employee.getRole());

            finalList.add(dto);
        }

        return finalList;
    }




}
