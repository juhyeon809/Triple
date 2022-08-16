package com.project.triple.repository;

import com.project.triple.model.entity.Air.Airport;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundTicketReservationRepository extends JpaRepository<RoundTicketReservation, Long> {

    List<RoundTicketReservation> findAllByOrderByIdxDesc();
}
