package com.example.homesupportbackend.authority_module.service;

import com.example.homesupportbackend.authentication_module.entity.auth_identity;
import com.example.homesupportbackend.authentication_module.repository.AuthIdentityRepositroy;
import com.example.homesupportbackend.authority_module.dto.DashBoardRecentServiceResponseDTO;
import com.example.homesupportbackend.authority_module.dto.DashBoardStatsResponseDTO;
import com.example.homesupportbackend.authority_module.dto.DashBoardStatsServiceResponseDTO;
import com.example.homesupportbackend.authority_module.interfacial.DashBoardStatsProjections;
import com.example.homesupportbackend.authority_module.interfacial.DashBoardStatsServiceProjections;
import com.example.homesupportbackend.dto.RequestSummaryDTO;
import com.example.homesupportbackend.entity.BookingStatus;
import com.example.homesupportbackend.repository.BookingRequestRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
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

    public List<DashBoardRecentServiceResponseDTO> dashBoardRecentService(String user_id){
        Optional<auth_identity> optionalAuthIdentity=authIdentityRepositroy.findById(user_id);
        auth_identity AuthIdentity = optionalAuthIdentity.orElseThrow(
                ()->new RuntimeException("Unauthorised Access!!")
        );

        int days=90;

        LocalDate endDate1= LocalDate.now();
        LocalDate startDate1=endDate1.minusDays(days);

        List<Object[]> completeList=bookingRequestRepository.getRecentService(startDate1,endDate1);



        List<DashBoardRecentServiceResponseDTO> finalList=new ArrayList<>();
        for(Object[] recentService:completeList){
            DashBoardRecentServiceResponseDTO dto=new DashBoardRecentServiceResponseDTO();
            dto.setBookingId((String) recentService[0]);
            dto.setProblemDesc((String) recentService[1]);
            dto.setServiceType((String) recentService[2]);
            dto.setLocation((String) recentService[3]);
            dto.setRoomNo((String) recentService[4]);


            OffsetDateTime createdAt = (OffsetDateTime) recentService[5];

            long minutes = Duration.between(
                    createdAt,
                    OffsetDateTime.now()
            ).toMinutes();
            String timeCalculated;

            if (minutes < 1) {
                timeCalculated = "Just now";
            } else if (minutes < 60) {
                timeCalculated = minutes + " minutes ago";
            } else if (minutes < 1440) {
                timeCalculated = (minutes / 60) + " hours ago";
            } else {
                timeCalculated = (minutes / 1440) + " days ago";
            }
            dto.setTimeCalculated(timeCalculated);

            finalList.add(dto);
        }
        return finalList;
    }
}
