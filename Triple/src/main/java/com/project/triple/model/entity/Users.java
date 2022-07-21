package com.project.triple.model.entity;

import com.project.triple.model.enumclass.UserStatus;
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
        name="seq_users",
        sequenceName = "seq_users",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Long id;
    private String userid;
    private String email;
    private String userpw;
    private String nickname;
    private String countryCode;
    private Integer zipcode;
    private String address1;
    private String address2;
    private String address3;
    @CreatedDate
    private LocalDateTime regDate;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String tosAgree;
}
