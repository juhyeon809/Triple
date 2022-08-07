package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicketType {

    AIR(0, "항공", "항공 티켓"),
    LODGING(1,"숙소", "숙소 티켓"),
    TOUR(2,"투어", "투어 티켓"),
    REVOKE(3, "취소", "취소된 티켓");

    private Integer id;
    private String title;
    private String description;
}
