package com.project.triple.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LodgingApiResponse {
    private Long id;
    private String companyNum;
    private String lodgingType;
    private String companyName;
    private String introducing;
    private String country;
    private String city;
    private String address;
    private String contactNUm;
    private String representative;
    private String email;
    private Integer likeNum;
}