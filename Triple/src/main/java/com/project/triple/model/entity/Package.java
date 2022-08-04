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
        name="seq_package",
        sequenceName = "seq_package",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_package")
    private Long idx;
    private String country;
    private String title;
    private String uploadPath;
    private String fileName;
    private String keyword;
    private Integer adultPr;
    private Integer kidPr;
    private Integer infantPr;
    private Integer adultInfantPr;
    private String program;
    private String contained;
    private String notContained;
    private String adminuserId;
    private String adminuserName;
    @CreatedDate
    private LocalDateTime regDate;

}
