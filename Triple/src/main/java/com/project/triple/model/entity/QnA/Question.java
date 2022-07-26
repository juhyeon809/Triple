package com.project.triple.model.entity.QnA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_question",
        sequenceName = "seq_question",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_question")
    private Long idx;
    private Integer inquaryId;
    private Integer ticketNum;
    private Integer userId;
    private String typeCategory;
    private String typeDetail;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private String infoAgree;
    @CreatedDate
    private LocalDateTime regDate;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
//    private List<Answer> answerList;



}
