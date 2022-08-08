package com.project.triple.controller.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirReservationInfo {

    private Long departureFlight;
    private Long comebackFlight;
    private String seatClass;
    private Integer adult;
    private Integer child;
    private Integer infant;

}
