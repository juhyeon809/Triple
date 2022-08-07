package com.project.triple.model.network.response;

import com.project.triple.model.enumclass.SaveType;
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
    private Long itemNum;
    private String saveYn;
    private String memo;
    private SaveType saveType;
    private LocalDateTime regDate;
}
