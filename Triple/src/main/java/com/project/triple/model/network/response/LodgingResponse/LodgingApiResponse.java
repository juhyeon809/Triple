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
    private String companyNum;
    private String lodgingType;
    private String companyName;
    private String introducing;
    private String country;
    private String city;
    private String address;
    private String contactHp;
    private String representative;
    private String email;
    private Integer likeCount;
    private String homepage;
}
