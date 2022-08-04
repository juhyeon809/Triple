package com.project.triple.repository;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Lodging.LodgingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LodgingTicketRepository extends JpaRepository<LodgingTicket, Long> {
    Optional<LodgingTicket> findAllByTicketNum(String ticketNum);

    List<LodgingTicket> findByTicketNum(String ticketNum);
}
