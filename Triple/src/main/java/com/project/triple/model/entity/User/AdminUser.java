package com.project.triple.model.entity.User;

import com.project.triple.model.entity.Faq;
import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.entity.QnA.Answer;
import com.project.triple.model.enumclass.AdminUserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_admin_user",
        sequenceName = "seq_admin_user",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_admin_user")
    private Long idx;
    private String userid;
    private String userpw;
    private String name;
    private String hp;
    private String email;
    private String department;
    private String position;
    @CreatedDate
    private LocalDateTime regDate;

    @Enumerated(EnumType.STRING)
    private AdminUserStatus status;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminUser")
//    private List<Magazine> magazineList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminUser")
//    private List<Guide> guideList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminUser")
//    private List<Answer> answerList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminUser")
//    private List<Notice> noticeList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminUser")
//    private List<Faq> faqList;
}
