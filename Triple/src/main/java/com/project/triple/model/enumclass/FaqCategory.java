package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FaqCategory {
    AIR(0, "항공", "항공 FAQ"),
    LODGING(1,"숙소", "숙소 FAQ"),
    TOUR(2,"투어", "투어 FAQ"),
    SERVICE(3,"서비스일반","서비스일반 FAQ"),
    COMMON(4, "공통","공통 FAQ"),
    BEST(5, "BEST", "BEST FAQ");


    private Integer id;
    private String title;
    private String description;
}
