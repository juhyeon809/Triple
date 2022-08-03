package com.project.triple.repository;

import com.project.triple.model.entity.Coupon.UserCoupon;
import com.project.triple.model.entity.Reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByUserId(Long userId);
}
