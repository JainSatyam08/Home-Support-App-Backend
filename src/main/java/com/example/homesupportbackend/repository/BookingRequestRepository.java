package com.example.homesupportbackend.repository;

import com.example.homesupportbackend.authority_module.dto.DashBoardRecentServiceResponseDTO;
import com.example.homesupportbackend.authority_module.interfacial.DashBoardStatsProjections;
import com.example.homesupportbackend.authority_module.interfacial.DashBoardStatsServiceProjections;
import com.example.homesupportbackend.entity.BookingRequest;
import com.example.homesupportbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRequestRepository extends JpaRepository<BookingRequest,String> {

    @Query(value = "SELECT nextval('booking_sequence')", nativeQuery = true)
    Long getNextBookingSequence();

    //@Override
    List<BookingRequest> findByUser(User user);

    @Query(value="""
    select count(*) as "total_comp",
    count(*) filter (where bs.status='Pending') as "new_count",
        count(*) filter (where bs.status='Reviewed') as "reviewed",
            count(*) filter (where bs.status='Completed') as "completed",
            count(*) filter (where bs.status='Cancelled') as "cancelled"
            from booking_request br 
                join booking_status bs 
                    on br.booking_id = bs.booking_id
            where br.created_at >= :startDate
            and br.created_at <= :endDate
    """,nativeQuery = true)
    DashBoardStatsProjections getDashBoardStats(
            @Param("startDate")LocalDate startDate,
            @Param("endDate") LocalDate endDate
            );

    @Query(value="""
    select 
    count(*) filter (where br.s_type='Electrician' or br.s_type='Electrical') as "Electrician",
        count(*) filter (where br.s_type='Plumbing') as "Plumbing",
            count(*) filter (where br.s_type='Cleaning') as "Cleaning",
            count(*) filter (where br.s_type='Appliance') as "Appliance"
            from booking_request br 
    """,nativeQuery = true)
    DashBoardStatsServiceProjections getDashBoardStatsService(

    );

    @Query("""
    SELECT 
        b.bookingId,
        b.problemDesc,
        b.serviceType,
        b.block,
        b.room,
        b.createdAt
    FROM BookingRequest b
    WHERE b.bookingDate >= :startDate
      AND b.bookingDate <= :endDate
    ORDER BY b.bookingDate DESC
""")
    List<Object[]> getRecentService(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );



}
