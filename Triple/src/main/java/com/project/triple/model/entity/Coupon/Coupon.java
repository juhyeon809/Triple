package com.project.triple.model.entity.Coupon;

import com.project.triple.model.enumclass.CouponStatus;
import com.project.triple.model.enumclass.CouponUse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_coupon",
        sequenceName = "seq_coupon",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_coupon")
    private Long id;
    private Integer couponId;
    private String name;
    private String type;
    private BigDecimal price;
    private String useCondition;
    private CouponStatus useStatus;
    private String code;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private CouponUse couponUse;

}
