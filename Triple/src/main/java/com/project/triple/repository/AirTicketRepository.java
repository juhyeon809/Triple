package com.project.triple.repository;

import com.project.triple.model.entity.AirTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirTicketRepository extends JpaRepository<AirTicket, Long> {

}
