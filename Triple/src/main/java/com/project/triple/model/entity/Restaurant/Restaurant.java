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
    private String country;
    private String city;
    private String location;
    private String title;
    private String summary;
    private String menuName1;
    private String menuDescription1;
    private String menuPrice1;
    private String menuName2;
    private String menuDescription2;
    private String menuPrice2;
    private String menuName3;
    private String menuDescription3;
    private String menuPrice3;
    private String howTogo;
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
    private Integer totalStar;
    private Double starCount;
    private Integer reviewCount;

}
