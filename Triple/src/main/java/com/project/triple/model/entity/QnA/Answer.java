package com.project.triple.model.entity.QnA;

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
        name="seq_answer",
        sequenceName = "seq_answer",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_answer")
    private Long id;
    private Integer answerNum;
    private Integer inquaryId;
    private Integer adminuserId;
    private String adminuserName;
    private String title;
    private String content;
    @CreatedDate
    private LocalDateTime regDate;
}
