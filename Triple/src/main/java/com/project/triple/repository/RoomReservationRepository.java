package com.project.triple.repository;

import com.project.triple.model.entity.Reservation.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {

    List<RoomReservation>  findAllByRoomId(Long id);
}
