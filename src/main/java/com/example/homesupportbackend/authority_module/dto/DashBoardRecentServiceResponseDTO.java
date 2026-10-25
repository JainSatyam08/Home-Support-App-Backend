package com.example.homesupportbackend.authority_module.dto;

public class DashBoardRecentServiceResponseDTO {
    private String bookingId;
    private String problemDesc;
    private String roomNo;
    private String serviceType;
    private String timeCalculated;
    private String Location;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getTimeCalculated() {
        return timeCalculated;
    }

    public void setTimeCalculated(String timeCalculated) {
        this.timeCalculated = timeCalculated;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
