package com.example.homesupportbackend.authority_module.service;

import com.example.homesupportbackend.authentication_module.entity.auth_identity;
import com.example.homesupportbackend.authentication_module.repository.AuthIdentityRepositroy;
import com.example.homesupportbackend.authority_module.dto.DashBoardStatsResponseDTO;
import com.example.homesupportbackend.authority_module.dto.DashBoardStatsServiceResponseDTO;
import com.example.homesupportbackend.authority_module.interfacial.DashBoardStatsProjections;
import com.example.homesupportbackend.authority_module.interfacial.DashBoardStatsServiceProjections;
import com.example.homesupportbackend.repository.BookingRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.Optional;
@Service
public class DashBoardStatsService {
    private final AuthIdentityRepositroy authIdentityRepositroy;
    private final BookingRequestRepository bookingRequestRepository;
    public DashBoardStatsService(AuthIdentityRepositroy authIdentityRepositroy,BookingRequestRepository bookingRequestRepository){
        this.authIdentityRepositroy=authIdentityRepositroy;
        this.bookingRequestRepository=bookingRequestRepository;
    }
    public DashBoardStatsResponseDTO dashBoardStats(int days,String user_id){
        Optional<auth_identity> optionalAuthIdentity=authIdentityRepositroy.findById(user_id);
        auth_identity AuthIdentity = optionalAuthIdentity.orElseThrow(
                ()->new RuntimeException("Unauthorised Access!!")
        );

        LocalDate endDate= LocalDate.now();
        LocalDate startDate=endDate.minusDays(days);
        DashBoardStatsProjections result=bookingRequestRepository.getDashBoardStats(startDate,endDate);
        DashBoardStatsResponseDTO dto=new DashBoardStatsResponseDTO();
        dto.setTotal(result.getTotalComp());
        dto.setNewcount(result.getNewCount());
        dto.setReviewed(result.getReviewed());
        dto.setCompleted(result.getCompleted());
        dto.setCancelled(result.getCancelled());

        return dto;


    }

    public DashBoardStatsServiceResponseDTO dashBoardStatsService(String user_id){
        Optional<auth_identity> optionalAuthIdentity=authIdentityRepositroy.findById(user_id);
        auth_identity AuthIdentity = optionalAuthIdentity.orElseThrow(
                ()->new RuntimeException("Unauthorised Access!!")
        );


        DashBoardStatsServiceProjections result=bookingRequestRepository.getDashBoardStatsService();
        DashBoardStatsServiceResponseDTO dto=new DashBoardStatsServiceResponseDTO();
        dto.setElectrician(result.getElectrician());
        dto.setPlumbing(result.getPlumbing());
        dto.setCleaning(result.getCleaning());
        dto.setAppliance(result.getAppliance());

        return dto;


    }
}
