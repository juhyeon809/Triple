package com.project.triple.model.entity.Reservation;

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
        name="seq_round_ticket_reservation",
        sequenceName = "seq_round_ticket_reservation",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "round_ticket_reservation")
public class RoundTicketReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_round_ticket_reservation")
    private Long idx;
    private String email;
    private Long departureTicketId;
    private Long comebackTicketId;
    private String ageType;
    private String seatClass;
    private String engLastname;
    private String engFirstname;
    private String birth;
    private String gender;
    private String useHp;
    private String nationality;
    private String passportNum;
    private String passportExp;
    private String passportCountry;
    private String passengerName;
    @CreatedDate
    private LocalDateTime regDate;

//    @ManyToOne
//    private Users users;
}
