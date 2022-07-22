package com.project.triple.model.network.response.AirResponse;

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
public class AirTicketApiResponse {
    private Long id;
    private String ticketType;
    private String ticketNum;
    private Integer airlineId;
    private Integer aircraftId;
    private String departureAirport;
    private String landingAirport;
    private LocalDateTime departureDate;
    private LocalDateTime landingDate;
    private BigDecimal price;
    private String seatNum;
    private String seatGrade;
    private String baggage;
    private String revDate;
    private TicketStatus status;
}