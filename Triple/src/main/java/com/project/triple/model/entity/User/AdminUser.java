package com.project.triple.model.entity.User;

import com.project.triple.model.entity.Faq;
import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.entity.QnA.Answer;
import com.project.triple.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_adminuser",
        sequenceName = "seq_adminuser",
        initialValue = 1,

        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adminuser")
    private Long idx;
    private String userid;
    private String userpw;
    private String name;
    @CreatedDate
    private LocalDateTime regDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminuser")
    private List<Magazine> magazineList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminuser")
    private List<Guide> guideList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminuser")
    private List<Answer> answerList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminuser")
    private List<Notice> noticeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminuser")
    private List<Faq> faqList;
}
