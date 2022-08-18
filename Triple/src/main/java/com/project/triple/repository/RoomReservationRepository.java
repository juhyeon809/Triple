package com.project.triple.repository;

import com.project.triple.model.entity.Reservation.RoomReservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {

    List<RoomReservation>  findAllByRoomId(Long id);

    List<RoomReservation> findByUserEmailOrderByIdxDesc(String email);

    RoomReservation findByIdx(Long idx);

    List<RoomReservation> findAllByUserEmail(String email);
}
