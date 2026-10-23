package com.example.homesupportbackend.authentication_module.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="auth_identity")
public class auth_identity {
    @Id
    @Column(name="user_id")
    private String user_id;

    @Column(name = "email_id")
    private String email;
    @Column(name="phone_number")
    private String phone;

    @Column(name="password_hash")
    private String password;

    @Column(name="acc_type")
    private String acc_type;

    @Column(name = "role_define")
    private String role;

    @Column(name="verified")
    private Boolean verified;




    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail_id() {
        return email;
    }

    public void setEmail_id(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}
}
