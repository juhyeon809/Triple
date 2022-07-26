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
        name="seq_guide_review",
        sequenceName = "seq_guide_review",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class GuideReview {
    @Id
    @GeneratedValue
    private Long idx;
    private Integer reviewNum;
    private String title;
    private String content;
    private String nickname;
//    private String userId;
    private String uploadPath;
    private String fileName;
    private String fileType;
    @CreatedDate
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer replyCount;

    @ManyToOne
    private Users users;
}
