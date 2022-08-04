package com.project.triple.model.entity.Coupon;

import com.project.triple.model.entity.User.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_user_coupon",
        sequenceName = "seq_user_coupon",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_coupon")
    private Long idx;
    private Long userId;
    private Long couponId;
    @CreatedDate
    private LocalDateTime regDate;

//    @ManyToOne
//    private Users users;
//
//    @ManyToOne
//    private Coupon coupon;
}
