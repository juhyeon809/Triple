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
        name="seq_magazine",
        sequenceName = "seq_magazine",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_magazine")
    private Long idx;
    private Integer adminuserId;
    private String adminuserName;
    private Integer magazineNum;
    private String magazineType;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    @CreatedDate
    private LocalDateTime regDate;

}
