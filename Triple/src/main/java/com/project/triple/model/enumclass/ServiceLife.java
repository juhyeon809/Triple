package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceLife {

    USABLE(0, "사용가능", "사용가능상태"),
    UNUSABLE(1,"사용불가", "사용불가상태");

    private Integer id;
    private String title;
    private String description;
}
