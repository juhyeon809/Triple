package com.project.triple.model.entity;


import com.project.triple.model.enumclass.OperationStatus;
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
        name="seq_spot",
        sequenceName = "seq_spot",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_spot")
    private Long id;
    private Integer spotNum;
    private String spotName;
    private String country;
    private String city;
    private String hp;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    @Enumerated(EnumType.STRING)
    private OperationStatus status;
    @CreatedDate
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer reviewCount;
}
