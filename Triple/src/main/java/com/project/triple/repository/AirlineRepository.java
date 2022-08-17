package com.project.triple.repository;

import com.project.triple.model.entity.Air.Airline;
import com.project.triple.model.entity.Reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    List<Airline> findAllByOrderByIdxDesc();
}
