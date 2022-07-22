package com.project.triple.model.enumclass;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {

    MALE(0, "남자", "남자입니다"),
    FEMALE(1,"여자", "여자입니다");

    private Integer id;
    private String title;
    private String description;
}
