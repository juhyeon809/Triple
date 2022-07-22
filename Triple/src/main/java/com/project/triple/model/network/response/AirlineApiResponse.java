package com.project.triple.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirlineApiResponse {
    private Long idx;
    private Integer airlineNum;
    private String krName;
    private String enName;
    private String airlineCode;
    private String address;
    private String contactNum1;
    private String contactNum2;
}
