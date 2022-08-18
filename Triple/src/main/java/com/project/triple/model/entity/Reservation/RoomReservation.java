package com.project.triple.model.entity.Reservation;


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
        name="seq_room_reservation",
        sequenceName = "seq_room_reservation",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class RoomReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_room_reservation")
    private Long idx;
    private Long roomId;
    private String userEmail;
    private String startDate;
    private String endDate;
    private String lastName;
    private String firstName;
    private String birth;
    private String gender;
    private String request;
    private Integer totalPrice;
    @CreatedDate
    private LocalDateTime regDate;
}
