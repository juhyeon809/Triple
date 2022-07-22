package com.project.triple.model.entity.Air;


import com.project.triple.model.enumclass.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_air_ticket",
        sequenceName = "seq_air_ticket",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AirTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_air_ticket")
    private Long idx;
    private String ticketType;
    private String ticketNum;
    private Integer airlineId;
    private Integer aircraftId;
    private String departureAirport;
    private String landingAirport;
    private LocalDateTime departureDate;
    private LocalDateTime landingDate;
    private Integer price;
    private String seatNum;
    private String seatGrade;
    private String baggage;
    @CreatedDate
    private LocalDateTime revDate;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

}
