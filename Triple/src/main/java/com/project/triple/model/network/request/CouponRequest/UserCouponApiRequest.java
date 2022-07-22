package com.project.triple.model.network.request.CouponRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCouponApiRequest {
    private Long id;
    private String userId;
    private Integer couponId;
    private LocalDateTime regDate;
}
