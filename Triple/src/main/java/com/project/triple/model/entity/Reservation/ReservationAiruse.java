package com.project.triple.model.entity.Reservation;

import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.Gender;
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
        name="seq_reservation_airuse",
        sequenceName = "seq_reservation_airuse",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ReservationAiruse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reservation_airuse")
    private Long idx;
//    private Integer userid;
    private String ticketType;
    private Integer ticketNum;
    private String engLastname;
    private String engFirstname;
    private String birth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String useHp;
    private String nationality;
    private String passportNum;
    private String passportExp;
    private String passportCount;
    private String infoAgree;

    @CreatedDate
    private LocalDateTime regDate;

//    @ManyToOne
//    private Users users;
}
