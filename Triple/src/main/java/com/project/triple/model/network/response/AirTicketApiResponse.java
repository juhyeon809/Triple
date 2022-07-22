package com.project.triple.model.network.response;

import com.project.triple.model.enumclass.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirTicketApiResponse {
    private Long x;
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
    private String revDate;
    private TicketStatus status;
}
