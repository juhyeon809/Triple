package com.project.triple.model.network.response.LodgingResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LodgingApiResponse {
    private Long idx;
    private String type;
    private String country;
    private String city;
    private Integer rank;
    private String name;
    private String uploadPath;
    private String fileName;
    private String info;
    private String introducing;
    private String address;
    private String checkIn;
    private String checkOut;
    private String policy;
    private String cf;
    private String moreInfo;
    private Integer totalStar;
    private Double starCount;
    private Integer reviewCount;
    private Integer cheapestPrice;
}
