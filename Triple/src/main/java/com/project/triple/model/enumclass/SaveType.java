package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SaveType {

    GUIDE(0, "가이드", "가이드 내저장"),
    SPOT(1,"관광", "관광 내저장"),
    RESTAURANT(2,"맛집", "맛집 내저장"),
    LODGING(3,"숙소", "숙소 내저장"),
    TOUR(4,"투어", "투어 내저장");


    private Integer id;
    private String title;
    private String description;
}
