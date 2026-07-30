package com.example.homesupportbackend.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_status")
public class BookingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long trackId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id",nullable = false)
    private BookingRequest bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "c_name", nullable = false)
    private String customerName;

    @Column(name = "cno", nullable = false)
    private String phoneNumber;

    @Column(name = "s_type", nullable = false)
    private String serviceType;

    @Column(name = "address_comp", columnDefinition = "TEXT", nullable = false)
    private String addressComplete;

    @Column(name="status",nullable = false,length=10)
    private String status = "Pending";

    @Column(name = "status_update_at", nullable = false,
            insertable = false,
            updatable = false)
    private LocalDateTime statusUpdateAt;

    @Column(name = "asign_p_id")
    private Long assignedServicePartnerId;

    public BookingStatus() {
    }


    public User getUser(){return user;}
    public void setUser(User user){ this.user=user;}

    public Long getTrackId(){return trackId;}
    public void setTrackId(Long trackId){
        this.trackId=trackId;
    }




    public BookingRequest getBookingRequest(){return bookingId;}

    public void setBookingRequest(BookingRequest bookingId){
        this.bookingId=bookingId;
    }

    public String getCname(){return customerName;}
    public void setCname (String cname){
        this.customerName = cname;
    }

    public String getCno(){return phoneNumber;}
    public void setCno(String cno){
        this.phoneNumber = cno;
    }

    public String getServiceType(){return serviceType;}
    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public String getAddressComplete(){return addressComplete;}
    public void setAddressComplete (String addressComplete){
        this.addressComplete = addressComplete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStatusUpdateAt() {
        return statusUpdateAt;
    }

    public void setStatusUpdateAt(LocalDateTime statusUpdateAt) {
        this.statusUpdateAt = statusUpdateAt;
    }

    public Long getAssignedServicePartnerId() {
        return assignedServicePartnerId;
    }

    public void setAssignedServicePartnerId(Long assignedServicePartnerId) {
        this.assignedServicePartnerId = assignedServicePartnerId;
    }


}