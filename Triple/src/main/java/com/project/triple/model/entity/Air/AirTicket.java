package com.project.triple.model.entity.Air;


import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.enumclass.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    private String airRoute;
    private String departureAirport;
    private String landingAirport;
    private String departureTime;
    private String landingTime;
    private String flightTime;
    private String airlineName;
    private String aircraftName;
    private String baggage;
    private Integer economyAdultPrice;
    private Integer economyChildPrice;
    private Integer economyInfantPrice;
    private Integer premiumAdultPrice;
    private Integer premiumChildPrice;
    private Integer premiumInfantPrice;
    private Integer businessAdultPrice;
    private Integer businessChildPrice;
    private Integer businessInfantPrice;
    private Integer firstAdultPrice;
    private Integer firstChildPrice;
    private Integer firstInfantPrice;
    private Integer premiumSeatCount;
    private Integer firstSeatCount;
    private Integer businessSeatCount;
    private Integer economySeatCount;
    @CreatedDate
    private LocalDateTime regDate;

}
