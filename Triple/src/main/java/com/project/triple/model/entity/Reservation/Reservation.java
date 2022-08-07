package com.project.triple.model.entity.Reservation;


import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.ServiceLife;
import com.project.triple.model.enumclass.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_reservation",
        sequenceName = "seq_reservation",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_reservation")
    private Long idx;
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private String ticketNum;
    private String revName;
    private String email;
    private String hp;
    private String emergencyHp;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime revDate;
    @Enumerated(EnumType.STRING)
    private ServiceLife serviceLife;

//    @ManyToOne
//    private Users users;
}
