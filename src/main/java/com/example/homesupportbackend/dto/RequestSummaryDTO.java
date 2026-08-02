package com.example.homesupportbackend.dto;



import java.time.LocalDate;

public class RequestSummaryDTO {
    private String bookingId;
    private String status;
    private long trackId;
    private String serviceType;


    private LocalDate statusUpdatedAt;

    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public long getTrackId() {
        return trackId;
    }
    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDate getStatusUpdatedAt() {
        return statusUpdatedAt;
    }
    public void setStatusUpdatedAt(LocalDate statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }
}
