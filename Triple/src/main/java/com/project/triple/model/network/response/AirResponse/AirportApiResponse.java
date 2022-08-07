package com.project.triple.model.network.response.AirResponse;

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
    private String airportName;
    private String country;
    private String city;
}
