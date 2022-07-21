package com.project.triple.model.entity;

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
        name="seq_spot_review",
        sequenceName = "seq_spot_review",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SpotReview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_spot_review")
    private Long id;
    private String reviewNum;
    private String title;
    private String content;
    private String nickname;
    private String userId;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private Integer likeCount;
    private Integer replyCount;
    @CreatedDate
    private LocalDateTime regDate;
    private String starCount;


}
