package com.project.triple.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportApiRequest {
    private Long idx;
    private String airportNum;
    private String airportName;
    private String airportCode;
    private String country;
    private String city;
}
