package com.project.triple.repository;

import com.project.triple.model.entity.Coupon.Coupon;
import com.project.triple.model.entity.Coupon.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByCouponId(Long couponId);

//    Optional<UserCoupon> findByUserId(Long userId);

}
