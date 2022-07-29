package com.project.triple.repository;

import com.project.triple.model.entity.Air.AirTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface AirTicketRepository extends JpaRepository<AirTicket, Long> {

    List<AirTicket> findTop10BySeatGrade(String seatGrade);
}
