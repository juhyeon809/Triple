package com.project.triple.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportApiResponse {
    private Long idx;
    private String airportNum;
    private String airportName;
    private String airportCode;
    private String country;
    private String city;
}
