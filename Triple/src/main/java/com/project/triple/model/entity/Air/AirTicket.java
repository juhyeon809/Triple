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
    private String ticketType;
    private String ticketNum;
    private Long airlineId;
    private Long aircraftId;
//    private Integer airlineIdx;
//    private Integer aircraftIdx;
    private String departureAirport;
    private String landingAirport;
    private LocalDateTime departureDate;
    private LocalDateTime landingDate;
    private BigDecimal price;
    private String seatNum;
    private String seatGrade;
    private String baggage;
    @CreatedDate
    private LocalDateTime revDate;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

//    @ManyToOne
//    private Airline airline;
//

//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airTicket")
//    private List<Question> questionList;

}
