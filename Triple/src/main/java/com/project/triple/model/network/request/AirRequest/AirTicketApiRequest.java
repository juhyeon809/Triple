package com.project.triple.model.network.request.AirRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.project.triple.model.enumclass.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirTicketApiRequest {
    private Long idx;
    private String ticketType;
    private String ticketNum;
    private Integer airlineIdx;
    private Integer aircraftIdx;
    private String departureAirport;
    private String landingAirport;
    private LocalDateTime departureDate;
    private LocalDateTime landingDate;
    private BigDecimal price;
    private String seatNum;
    private String seatGrade;
    private String baggage;
    private LocalDateTime revDate;
    private TicketStatus status;
}
