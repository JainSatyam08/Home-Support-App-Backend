package com.example.homesupportbackend.authentication_module.dto;

public class EmployeeLoginResponseDTO {

    private String token;
    private String role;
    private String name;
    public EmployeeLoginResponseDTO(String token,String role,String name){
        this.token=token;
        this.role=role;
        this.name=name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
