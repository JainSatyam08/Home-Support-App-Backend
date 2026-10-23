package com.example.homesupportbackend.authority_module.controller;


import com.example.homesupportbackend.authority_module.dto.DashBoardStatsResponseDTO;
import com.example.homesupportbackend.authority_module.dto.DashBoardStatsServiceResponseDTO;
import com.example.homesupportbackend.authority_module.service.DashBoardStatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/employee")
public class DashBoardStatsController {
    private final DashBoardStatsService dashBoardStatsService;
    public DashBoardStatsController(DashBoardStatsService dashBoardStatsService){
        this.dashBoardStatsService=dashBoardStatsService;
    }

    @GetMapping("/stats")
    public ResponseEntity<DashBoardStatsResponseDTO> getDashBoardStats(
            @RequestParam(defaultValue = "7") int days,
            Authentication authentication
    ){
        String user_id=authentication.getName();
        return ResponseEntity.ok(dashBoardStatsService.dashBoardStats(days,user_id));

    }
    @GetMapping("/statservice")
    public ResponseEntity<DashBoardStatsServiceResponseDTO> getDashBoardStatsService(
            Authentication authentication
    ){
        String user_id=authentication.getName();
        return ResponseEntity.ok(dashBoardStatsService.dashBoardStatsService(user_id));

    }
}
