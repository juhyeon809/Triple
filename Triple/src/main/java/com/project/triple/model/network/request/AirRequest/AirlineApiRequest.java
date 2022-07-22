package com.project.triple.model.network.request.AirRequest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirlineApiRequest {
    private Long idx;
    private Integer airlineNum;
    private String krName;
    private String enName;
    private String airlineCode;
    private String address;
    private String contactNum1;
    private String contactNum2;
}
