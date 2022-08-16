package com.project.triple.controller.page;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomSearch {
    private String country;
    private String city;
    private String type;
    private Integer rank;
    private Integer reviewCount;
    private Integer leastPrice;
    private Integer maxPrice;
    private String cf;
}
