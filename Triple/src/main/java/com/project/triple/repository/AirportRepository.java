package com.project.triple.repository;

import com.project.triple.model.entity.Air.Airport;
import com.project.triple.model.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findAllByOrderByIdxDesc();
}
