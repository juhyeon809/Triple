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
    private String location;
    private String title;
    private String summary;
    private String menu1Name;
    private String menu1Description;
    private String menu1Price;
    private String menu2Name;
    private String menu2Description;
    private String menu2Price;
    private String menu3Name;
    private String menu3Description;
    private String menu3Price;
    private String howToGO;
    private String availableAt;
    private String tip;
    private String etc;
    private String uploadPath1;
    private String fileName1;
    private String uploadPath2;
    private String fileName2;
    private String uploadPath3;
    private String fileName3;
    private String uploadPath4;
    private String fileName4;
    private String adminuserId;
    private String adminuserName;
    @CreatedDate
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer reviewCount;

}
