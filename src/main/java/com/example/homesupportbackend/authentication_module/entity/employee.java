package com.example.homesupportbackend.authentication_module.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class employee {

    @Id
    @Column(name="emp_id")
    private String emp_id;

    @OneToOne
    @JoinColumn(
            name="emp_id",
            referencedColumnName = "user_id"
    )
    @MapsId
    private auth_identity authIdentity;

    @Column(name="password_hash")
    private String password;
    @Column(name="employee_name")
    private String emp_name;
    @Column(name="email_id")
    private String email;
    @Column(name="phone_number")
    private String phone;
    @Column(name="account_type")
    private String actype;
    @Column(name="employee_role")
    private String role;
    @Column(name="verified")
    private String verify;
    @Column(name="aadhaar_number")
    private String aadhaar;
    @Column(name="address")
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public auth_identity getAuthIdentity() {
        return authIdentity;
    }

    public void setAuthIdentity(auth_identity authIdentity) {
        this.authIdentity = authIdentity;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getActype() {
        return actype;
    }

    public void setActype(String actype) {
        this.actype = actype;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
