package com.project.triple.model.entity;

import com.project.triple.model.entity.User.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_review",
        sequenceName = "seq_review",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_review")
    private Long idx;
    private String reviewNum;
    private String title;
    private String content;
    private String nickname;
    private Integer starCount;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private Integer likeCount;
    private LocalDateTime regDate;
    private String ticketNum;
//    private Integer userid;

    @ManyToOne
    private Users users;
}
