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
    private Integer aircraftNum;
    private String aircraftName;
    private String madeBy;
    private Integer aircraftCapacity;
    private Integer normalSeat;
    private Integer economySeat;
    private Integer specialSeat;
    private Integer familySeat;
    private Integer vipSeat;
    private Integer airlineId;
}
