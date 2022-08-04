package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MagazineType {

    RECOMMEND(0, "여행지추천", "여행지 추천 카테고리"),
    TIP(1,"여행꿀팁", "여행꿀팁 카테고리"),
    RESTAURANT(2,"맛집탐방", "맛집탐방 카테고리"),
    AIR(3,"항공,공항", "항공,공항 카테고리"),
    LODGING(4,"숙소추천", "숙소추천 카테고리"),
    TOURTICKET(5,"투어,티켓", "투어,티켓 카테고리"),
    SHOPPING(6,"쇼핑", "쇼핑 카테고리"),
    TRAVELS(7, "여행기", "여행기 카테고리");

    private Integer id;
    private String title;
    private String description;

}
