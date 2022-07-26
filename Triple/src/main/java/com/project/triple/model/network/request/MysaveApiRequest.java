package com.project.triple.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MysaveApiRequest {
    private Long idx;
    //    private Integer userid;
    private Integer itemNum;
    private String saveYn;
    private String memo;
    private String saveType;
    private LocalDateTime regDate;
}
