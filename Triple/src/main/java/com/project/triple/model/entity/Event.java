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
        name="seq_event",
        sequenceName = "seq_event",
        initialValue = 1,
        allocationSize = 1
)

@Builder
@EntityListeners(AuditingEntityListener.class)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event")
    private Long idx;
    private String adminuserId;
    private String adminuserName;
    private String eventType;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    @CreatedDate
    private LocalDateTime regDate;

}
