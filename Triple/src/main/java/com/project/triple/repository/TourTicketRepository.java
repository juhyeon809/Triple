package com.project.triple.repository;

import com.project.triple.model.entity.TourTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourTicketRepository extends JpaRepository<TourTicket, Long> {
}
