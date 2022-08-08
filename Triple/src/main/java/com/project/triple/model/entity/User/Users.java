package com.project.triple.model.entity.User;

import com.project.triple.model.enumclass.UserStatus;
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
        name="seq_users",
        sequenceName = "seq_users",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Long idx;
    private String email;
    private String userpw;
    private String nickname;
    private String countryCode;
    private String hp;
    private Integer zipcode;
    private String address1;
    private String address2;
    private String address3;
    @CreatedDate
    private LocalDateTime regDate;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String tosAgree;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<ReservationAiruse> reservationAiruseList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<Reservation> reservationList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<Review> reviewList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<ReviewReply> reviewReplyList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<SpotReview> spotReviewList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<TourSpotReviewReply> tourSpotReviewReplyList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<RestaurantReview> restaurantReviewList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<RestaurantReviewReply> restaurantReviewReplyList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<UserCoupon> userCouponList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<GuideReview> guideReviewList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<GuideReviewReply> guideReviewReplyList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<Tripler> triplerList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<TriplerReply> triplerReplyList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<Mysave> mysaveList;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<Question> questionList;
}
