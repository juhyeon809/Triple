package com.project.triple.model.enumclass;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GuideType {

    AIRPORT(0, "공항 정보", "공항 정보 카테고리"),
    DOMESTICAIR(1,"국내공항 안내", "국내 공항 안내 카테고리"),
    CHECK(3,"출발 전 확인", "출발 전 확인 카테고리");

    private Integer id;
    private String title;
    private String description;
}
