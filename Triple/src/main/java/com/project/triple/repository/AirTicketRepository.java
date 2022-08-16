package com.project.triple.repository;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Coupon.Coupon;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface AirTicketRepository extends JpaRepository<AirTicket, Long> {

    List<AirTicket> findAllByAirRoute(String route);

    List<AirTicket> findAllByDepartureAirportAndLandingAirportAndDepartureTimeContaining(String departureAirport, String landingAirport,String departureTime);
    List<AirTicket> findAllByOrderByIdxDesc();

    AirTicket findAllByIdx(Long departureTicketId);

    Optional<AirTicket> findByIdx(Long idx);
}
