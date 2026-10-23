package com.example.homesupportbackend.authority_module.interfacial;

public interface DashBoardStatsProjections {
    Long getTotalComp();

    Long getNewCount();

    Long getReviewed();

    Long getCompleted();

    Long getCancelled();
}
