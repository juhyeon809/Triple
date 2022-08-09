package com.project.triple.repository;

import com.project.triple.model.entity.Reservation.OnewayReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnewayReservationRepository extends JpaRepository<OnewayReservation , Long> {
}
