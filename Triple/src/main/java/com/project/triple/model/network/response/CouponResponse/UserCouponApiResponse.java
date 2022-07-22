package com.project.triple.model.network.response.CouponResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCouponApiResponse {
    private Long idx;
    private String userId;
    private Integer couponId;
    private LocalDateTime regDate;
}
