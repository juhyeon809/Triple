package com.project.triple.model.entity;

import com.project.triple.model.entity.User.AdminUser;
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
        name="seq_notice",
        sequenceName = "seq_notice",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_notice")
    private Long idx;
    private String adminuserId;
    private String adminuserName;
    private String noticeType;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    @CreatedDate
    private LocalDateTime regDate;

//    @ManyToOne
//    private AdminUser adminUser;
}
