package com.example.homesupportbackend.authority_module.dto;

public class DashBoardStatsResponseDTO {
    private long total;
    private long newcount;
    private long reviewed;
    private long completed;
    private long cancelled;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getNewcount() {
        return newcount;
    }

    public void setNewcount(long newcount) {
        this.newcount = newcount;
    }

    public long getReviewed() {
        return reviewed;
    }

    public void setReviewed(long reviewed) {
        this.reviewed = reviewed;
    }

    public long getCancelled() {
        return cancelled;
    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }

    public void setCancelled(long cancelled) {
        this.cancelled = cancelled;
    }
}
