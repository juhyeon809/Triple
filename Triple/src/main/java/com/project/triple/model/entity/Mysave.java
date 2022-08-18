package com.project.triple.model.entity;

import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.SaveType;
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
        name="seq_mysave",
        sequenceName = "seq_mysave",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Mysave {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mysave")
    private Long idx;
    private Long userId;
    private Long itemNum;
    private String saveYn;
    private String memo;
    @Enumerated(EnumType.STRING)
    private SaveType saveType;
    @CreatedDate
    private LocalDateTime regDate;
    private String location;
    private String title;
    private String summary;
    private String uploadPath;

//    @ManyToOne
//    private Users users;
}
