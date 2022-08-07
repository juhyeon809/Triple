package com.project.triple.model.network.request.AirRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftApiRequest {
    private Long idx;
    private String aircraftName;
    private String madeBy;
    private Integer aircraftCapacity;
    private Integer normalSeat;
    private Integer specialSeat;
    private Integer familySeat;
    private Integer premiumSeat;
    private Integer vipSeat;
    private String airlineName;
//    private Integer airlineId;
}
