package com.project.triple.repository;

import com.project.triple.model.entity.Air.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    List<Aircraft> findAllByAirlineName(String name);

    Aircraft findByAircraftName(String name);

}
