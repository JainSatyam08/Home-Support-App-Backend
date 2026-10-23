package com.example.homesupportbackend.authentication_module.dto;

public class EmployeeSignUpRequestDTO {

    private String phone_number;
    private String name;
    private String email;
    private String role;
    private String aadhaar_number;
    private String address;
    private String account_type;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAadhaar_number() {
        return aadhaar_number;
    }

    public void setAadhaar_number(String aadhaar_number) {
        this.aadhaar_number = aadhaar_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
}
