package com.project.triple.repository;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Tour;
import com.project.triple.model.entity.TourTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourTicketRepository extends JpaRepository<TourTicket, Long> {
    Optional<TourTicket> findAllByTicketNum(String ticketNum);

    List<TourTicket> findByIdx(Long idx);

    List<TourTicket> findByTicketNum(String ticketNum);

}
