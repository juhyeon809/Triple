package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CouponStatus {

    USABLE(0, "사용가능", "사용 가능한 상태"),
    EXPIRED(1,"기간만료", "사용 불가능한 상태");


    private Integer id;
    private String title;
    private String description;
}
