package com.project.triple.repository;

import com.project.triple.model.entity.Lodging.LodgingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LodgingTicketRepository extends JpaRepository<LodgingTicket, Long> {

}
