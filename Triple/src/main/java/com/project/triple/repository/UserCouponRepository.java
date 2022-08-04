package com.project.triple.repository;

import com.project.triple.model.entity.Coupon.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {
    List<UserCoupon> findAllByUserId(Long userId);

    Optional<UserCoupon> findByUserId(Long userId);
}
