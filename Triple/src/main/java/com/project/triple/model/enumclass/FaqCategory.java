package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FaqCategory {
    항공(0, "항공", "항공 FAQ"),
    숙소(1,"숙소", "숙소 FAQ"),
    투어(2,"투어", "투어 FAQ"),
    서비스일반(3,"서비스일반","서비스일반 FAQ"),
    공통(4, "공통","공통 FAQ");


    private Integer id;
    private String title;
    private String description;
}
