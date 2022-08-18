package com.project.triple.repository;

import com.project.triple.model.entity.Coupon.UserCoupon;
import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByUserId(Long userId);

    List<Reservation> findAllByTicketType(TicketType ticketType);

    Reservation findByIdx(Long idx);

    Reservation findByTicketNum(String ticketNum);

    List<Reservation> findAllByOrderByIdxDesc();
}
