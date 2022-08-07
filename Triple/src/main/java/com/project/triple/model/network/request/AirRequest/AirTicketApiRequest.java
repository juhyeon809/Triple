package com.project.triple.model.network.request.AirRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.project.triple.model.enumclass.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirTicketApiRequest {
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
    private LocalDateTime regDate;
}
