package com.project.triple.model.network.response.AirResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftApiResponse {
    private Long idx;
    private String aircraftName;
    private String madeBy;
    private Integer aircraftCapacity;
    private Integer premiumSeat;
    private Integer firstSeat;
    private Integer businessSeat;
    private Integer economySeat;
    private String airlineName;
}
