package com.project.triple.model.entity.Guide;

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
        name="seq_guide_review_reply",
        sequenceName = "seq_guide_review_reply",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class GuideReviewReply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guide_review_reply")
    private Long idx;
    private Integer replyNum;
    private Integer reviewNum;
    private String title;
    private String content;
    private String nickname;
    private String userId;
    private Integer likeCount;
    @CreatedDate
    private LocalDateTime regDate;

//    @ManyToOne
//    private Users users;
}
