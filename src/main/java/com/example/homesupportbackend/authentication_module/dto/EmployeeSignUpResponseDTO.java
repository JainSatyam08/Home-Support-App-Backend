package com.example.homesupportbackend.authentication_module.dto;

public class EmployeeSignUpResponseDTO {

    private String message;
    private String emp_id;
    private String password;

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}