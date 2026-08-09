package com.example.homesupportbackend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestDetailDTO {
    private String bookingId;
    private String Status;
    private LocalDate prefDate;
    private LocalDate bookingDate;
    private String prefSlot;
    private String serviceType;
    private String problemType;
    private String problemDesc;
    private String Address;
    private String CustomerForName;
    private String CustomerForCno;
    private String CustomerEmail;
    private LocalDateTime statusUpdatedAt;
    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getStatusUpdatedAt() {
        return statusUpdatedAt;
    }

    public void setStatusUpdatedAt(LocalDateTime statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }

    public String getCustomerForName() {
        return CustomerForName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerForCno() {
        return CustomerForCno;
    }

    public void setCustomerForCno(String customerForCno) {
        CustomerForCno = customerForCno;
    }

    public void setCustomerForName(String customerForName) {
        CustomerForName = customerForName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }



    public String getPrefSlot() {
        return prefSlot;
    }

    public void setPrefSlot(String prefSlot) {
        this.prefSlot = prefSlot;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return Status;
    }

    public LocalDate getPrefDate() {
        return prefDate;
    }

    public void setPrefDate(LocalDate prefDate) {
        this.prefDate = prefDate;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
