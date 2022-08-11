package com.project.triple.controller.page;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchInfo {
    private String departureTime;
    private String comebackTime;
    private String onewayTime;
    private String departureAirport;
    private String landingAirport;
}
