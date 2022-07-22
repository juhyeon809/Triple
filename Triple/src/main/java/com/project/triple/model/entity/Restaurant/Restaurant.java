package com.project.triple.model.entity.Restaurant;

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
        name="seq_restaurant",
        sequenceName = "seq_restaurant",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_restaurant")
    private Long idx;
    private Integer restNum;
    private String restName;
    private String country;
    private String city;
    private String hp;
    private String address;
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
