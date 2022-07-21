package com.project.triple.repository;

import com.project.triple.model.entity.Tirpler.Tripler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriplerRepository extends JpaRepository<Tripler, Long> {
}
