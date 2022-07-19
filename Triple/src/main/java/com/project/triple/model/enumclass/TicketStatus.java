package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicketStatus {

    AVAILABLE(0, "예약가능", "티켓 예약 가능한 상태"),
    SOLDOUT(1,"판매완료", "티켓 판매 완료된 상태"),
    WAITING(2,"입금대기", "티켓 입금 대기중"),
    CANCELED(3,"주문취소","티켓 주문 취소됨"),
    NOTAVAILABLE(4, "예약불가능","티켓 예약 불가능한 상태");




    private Integer id;
    private String title;
    private String description;
}
