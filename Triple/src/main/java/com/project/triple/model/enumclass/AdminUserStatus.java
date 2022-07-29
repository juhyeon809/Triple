package com.project.triple.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdminUserStatus {

    /* admin_user 테이블의 status */
    REGISTERED(0, "가입", "관리자 가입상태"),
    UNREGISTERED(1, "탈퇴", "관리자 탈퇴상태");

    private Integer id;
    private String title;
    private String description;
}
