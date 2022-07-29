package com.project.triple.model.network.request.AirRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirTicketSearchRequest {
    private String departureAirport;
    private String landingAirport;
    private String departureDate;
}
