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
    private Long id;
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
