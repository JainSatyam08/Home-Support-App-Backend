package com.example.homesupportbackend.dto;
import java.time.LocalDate;


public class BookingRequestDTO {

    private String serviceType;

    private String problemType;

    private String problemDesc;

    private LocalDate prefDate;

    private String prefSlot;



    private String hostel;
    private String room;
    private String block;

    public LocalDate getPrefDate() {
        return prefDate;
    }

    public void setPrefDate(LocalDate prefDate) {
        this.prefDate = prefDate;
    }

    public String getPrefSlot() {
        return prefSlot;
    }

    public void setPrefSlot(String prefSlot) {
        this.prefSlot = prefSlot;
    }


    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
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


    public String getPreferredSlot(){return prefSlot;}
    public void setPreferredSlot(String preferredSlot){
        this.prefSlot = preferredSlot;
    }

    public LocalDate getPreferredDate(){return prefDate;}

    public void setPreferredDate(LocalDate preferredDate) {
        this.prefDate = preferredDate;
    }




}
