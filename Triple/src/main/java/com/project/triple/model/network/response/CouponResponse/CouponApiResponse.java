package com.project.triple.model.network.response.CouponResponse;

import com.project.triple.model.enumclass.CouponStatus;
import com.project.triple.model.enumclass.CouponUse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponApiResponse {
    private Long idx;
    private Long couponId;
    private String name;
    private String type;
    private BigDecimal price;
    private String useCondition;
    private CouponStatus useStatus;
    private String code;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CouponUse couponUse;
}
