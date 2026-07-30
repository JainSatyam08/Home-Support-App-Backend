package com.example.homesupportbackend.dto;



public class BookingResponseDTO {

    private String message;
    private String bookingId;
    private Long trackId;
    private String status;
    private String serviceType;
    private String customerName;
    private String phoneNumber;

    public String getMessage(){return message;}
    public void setMessage(String message){
        this.message=message;
    }



    public Long getTrackId(){return trackId;}
    public void setTrackId(Long trackId){
        this.trackId=trackId;
    }

    public String getBookingId(){return bookingId;}

    public void setBookingId(String bookingId){
        this.bookingId=bookingId;
    }

    public String getCname(){return customerName;}
    public void setCname (String cname){
        this.customerName = cname;
    }

    public String getPhoneNumber(){return phoneNumber;}
    public void setCno(String cno){
        this.phoneNumber = cno;
    }

    public String getServiceType(){return serviceType;}
    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
