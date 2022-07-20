package com.project.triple.repository;

import com.project.triple.model.entity.TourTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourTicketRepository extends JpaRepository<TourTicket, Long> {
}
