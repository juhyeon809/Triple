package com.project.triple.repository;

import com.project.triple.model.entity.Air.Airport;
import com.project.triple.model.entity.Lodging.LodgingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Optional<Airport> findByAirportName(String airportName);

    List<Airport> findAllByOrderByIdxDesc();
}
