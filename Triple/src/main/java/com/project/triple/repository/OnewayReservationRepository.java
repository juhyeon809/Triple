package com.project.triple.repository;

import com.project.triple.model.entity.Reservation.OnewayReservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OnewayReservationRepository extends JpaRepository<OnewayReservation , Long> {

    @Query(value = "SELECT * FROM oneway_reservation WHERE email=:email AND rownum=1", nativeQuery = true)
    Optional<OnewayReservation> findDepartureTicketId(String email);

    @Query(value = "SELECT * FROM oneway_reservation WHERE email=email AND rownum=1", nativeQuery = true)
    OnewayReservation findByIdx(String email);

    List<OnewayReservation> findAllByEmail(String email);

    Long countBySeatClass(String seatClass);

    @Query(value = "SELECT * FROM oneway_reservation WHERE email=:email AND rownum=1", nativeQuery = true)
    List<OnewayReservation> findByEmailOrderByIdxDesc(String email);
}
