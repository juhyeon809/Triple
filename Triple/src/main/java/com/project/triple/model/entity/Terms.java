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
        name="seq_terms",
        sequenceName = "seq_terms",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_terms")
    private Long idx;
    private String termsName;
    @CreatedDate
    private LocalDateTime regDate;
    private String content;
    private String ifRequired;
    private String ifUse;
}