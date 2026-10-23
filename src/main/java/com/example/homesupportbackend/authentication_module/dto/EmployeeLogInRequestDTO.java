package com.example.homesupportbackend.authentication_module.dto;

public class EmployeeLogInRequestDTO {
    private String emp_id;
    private String password;

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
