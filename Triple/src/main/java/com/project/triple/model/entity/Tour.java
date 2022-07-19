package com.project.triple.model.entity;

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
        name="seq_tour",
        sequenceName = "seq_tour",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_tour")
    private Long id;
    private String tourNum;
    private String country;
    private String address;
    private String managerName;
    private String contactNum;
    private String title;
    private String info;
    @Enumerated(EnumType.STRING)
    private String status;
    private Integer price;
    private String timeTaken;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer likeNum;
    private Integer remaining;
}
