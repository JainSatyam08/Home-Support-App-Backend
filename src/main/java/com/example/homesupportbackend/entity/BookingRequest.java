package com.example.homesupportbackend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="booking_request")
public class BookingRequest {
    @Id
    @Column(name="booking_id")
    private String bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;



    @Column(name="c_name",nullable = false)
    private String cname;

    @Column(name="c_f_name",nullable = false)
    private String cFName ;

    @Column(name="cno",nullable = false)
    private String cno ;

    @Column(name="c_f_cno",nullable = false)
    private String cFCno;

    @Column(name="email_id",nullable = false)
    private String emailId;
    @Column(name="s_type",nullable = false)
    private String serviceType ;
    @Column(name="problem_type")
    private String problemType;
    @Column(name="problem_desc",columnDefinition = "TEXT")
    private String problemDesc ;
    @Column(name="p_date",nullable = false)
    private LocalDate preferredDate;
    @Column(name="p_time",nullable = false)
    private String preferredSlot;


    private Double latitude;
    private Double longitude;

    @Column(name = "address_comp", columnDefinition = "TEXT")
    private String addressComplete;

    @Column(name = "book_date", nullable = false)
    private LocalDate bookingDate;

    public BookingRequest(){}

    public User getUser(){return user;}
    public void setUser(User user){ this.user=user;}




    public void setBookingId(String bookingId){
        this.bookingId=bookingId;
    }

    public String getBookingId(){return bookingId;}
    public String getCname(){return cname;}
    public void setCname (String cname){
        this.cname = cname;
    }

    public String getCno(){return cno;}
    public void setCno(String cno){
        this.cno = cno;
    }

    public String getCFName(){return cFName;}
    public void setCFName(String cFName){
        this.cFName = cFName;
    }

    public String getCFCno(){return cFCno;}
    public void setCFCno(String cFCno){
        this.cFCno = cFCno;
    }

    public String getEmailId(){return emailId;}
    public void setEmailId (String emailId){
        this.emailId = emailId;
    }

    public String getServiceType(){return serviceType;}
    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public String getProblemType(){return problemType;}
    public void setProblemType(String problemType){
        this.problemType = problemType;
    }

    public String getProblemDesc(){return problemDesc;}
    public void setProblemDesc(String problemDesc){
        this.problemDesc = problemDesc;
    }

    public String getAddressComplete(){return addressComplete;}
    public void setAddressComplete (String addressComplete){
        this.addressComplete = addressComplete;
    }

    public String getPreferredSlot(){return preferredSlot;}
    public void setPreferredSlot(String preferredSlot){
        this.preferredSlot = preferredSlot;
    }

    public LocalDate getPreferredDate(){return preferredDate;}

    public void setPreferredDate(LocalDate preferredDate) {
        this.preferredDate = preferredDate;
    }



    public LocalDate getBookingDate(){return bookingDate;}
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }


    public Double getLatitude(){return latitude;}

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {return longitude;}

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }





}
