package com.project.triple.model.entity;

import com.project.triple.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_adminuser",
        sequenceName = "seq_adminuser",
        initialValue = 1,

        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adminuser")
    private Long idx;
    private String userid;
    private String userpw;
    private String name;
    @CreatedDate
    private LocalDateTime regDate;
}
