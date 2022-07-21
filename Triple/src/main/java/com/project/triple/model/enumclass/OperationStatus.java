package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationStatus {

    AVAILABLE(0, "이용가능", "이용 가능한 상태"),
    NOTAVAILABLE(1,"이용불가", "이용 불가능한 상태");

    private Integer id;
    private String title;
    private String description;
}
