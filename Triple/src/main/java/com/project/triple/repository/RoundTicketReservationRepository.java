package com.project.triple.repository;

import com.project.triple.model.entity.Coupon.Coupon;
import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.entity.Air.Airport;
import com.project.triple.model.entity.Reservation.RoomReservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoundTicketReservationRepository extends JpaRepository<RoundTicketReservation, Long> {

    @Query(value = "SELECT * FROM round_ticket_reservation WHERE email=:email AND rownum=1", nativeQuery = true)
    Optional<RoundTicketReservation> findDepartureTicketId(String email);

//    @Query(value = "SELECT DISTINCT * FROM round_ticket_reservation WHERE email=:email AND rownum<=2", nativeQuery = true)
//    List<RoundTicketReservation> findDepartureTicketId(String email);

    @Query(value = "SELECT * FROM round_ticket_reservation WHERE email=:email AND rownum=1", nativeQuery = true)
    RoundTicketReservation findByEmail(String email);

//    List<RoundTicketReservation> findByEmail(String email);

    List<RoundTicketReservation> findAllByEmail(String email);

    Long countBySeatClass(String seatClass);

    List<RoundTicketReservation> findAllByOrderByIdxDesc();

    Optional<RoundTicketReservation> findByDepartureTicketId(Long departureTicketId);

    Optional<RoundTicketReservation> findByEmailOrderByIdx(String email);

    RoundTicketReservation findByIdx(Long idx);

    @Query(value = "SELECT * FROM round_ticket_reservation WHERE email=:email AND rownum=1", nativeQuery = true)
    List<RoundTicketReservation> findByEmailOrderByIdxDesc(String email);
}
