package com.project.triple.model.entity.Guide;


import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.enumclass.GuideType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_guide",
        sequenceName = "seq_guide",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guide")
    private Long idx;
    private String country;
    private String city;
    private String title;
    private String uploadPath;
    private String fileName;
    private String content;
    private String language;
    private String area;
    private String population;
    private String timeDifference;
    private String myth;
    private String voltage;
    private String currency;
    private String countryCode;
    private String visa;
    private String prices;
    private String air;
    private String climate;
    private String bestTime;
    private String simpleConversation;
    @CreatedDate
    private LocalDateTime regDate;
    private Integer reviewCount;
    private Integer totalStar;
    private Double starCount;

//    @ManyToOne
//    private AdminUser adminUser;

}
