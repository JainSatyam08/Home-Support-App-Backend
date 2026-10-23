package com.example.homesupportbackend.authority_module.dto;

public class DashBoardStatsServiceResponseDTO {
    private long electrician;
    private long plumbing;
    private long cleaning;
    private long appliance;

    public long getElectrician() {
        return electrician;
    }

    public void setElectrician(long electrician) {
        this.electrician = electrician;
    }

    public long getPlumbing() {
        return plumbing;
    }

    public void setPlumbing(long plumbing) {
        this.plumbing = plumbing;
    }

    public long getCleaning() {
        return cleaning;
    }

    public void setCleaning(long cleaning) {
        this.cleaning = cleaning;
    }

    public long getAppliance() {
        return appliance;
    }

    public void setAppliance(long appliance) {
        this.appliance = appliance;
    }
}
