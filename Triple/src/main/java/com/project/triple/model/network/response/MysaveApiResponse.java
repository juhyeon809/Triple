package com.project.triple.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MysaveApiResponse {
    private Long idx;
    private Long userId;
    private Integer itemNum;
    private String saveYn;
    private String memo;
    private String saveType;
    private LocalDateTime regDate;
}
