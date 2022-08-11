package com.project.triple.model.entity.Restaurant;

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
        name="seq_restaurant_review",
        sequenceName = "seq_restaurant_review",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class RestaurantReview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_restaurant_review")
    private Long idx;
    private Long postId;
    private String title;
    private String content;
    private String nickname;
    private String userEmail;
    private String uploadPath;
    private String fileName;
    private Integer likeCount;
    private Integer replyCount;
    @CreatedDate
    private LocalDateTime regDate;
    private Integer starCount;

//    @ManyToOne
//    private Users users;

}
