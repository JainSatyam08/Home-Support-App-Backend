package com.example.homesupportbackend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="cancellation")
public class Cancellation {
    @Id
    @Column(name="cancel_id")
    private String cancel_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="booking_id",nullable = false)
    private BookingRequest bookingId;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @Column(name="booking_date",nullable=false)
    private LocalDate bookingDate;

    @Column(name = "cancel_timestamp",nullable = false)
    private LocalDateTime cancelTime;

    @Column(name = "reason")
    private String reason;

    private Double latitude;
    private Double longitude;

    public String getCancel_id() {
        return cancel_id;
    }

    public void setCancel_id(String cancel_id) {
        this.cancel_id = cancel_id;
    }

    public BookingRequest getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingRequest bookingId) {
        this.bookingId = bookingId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }



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
}
