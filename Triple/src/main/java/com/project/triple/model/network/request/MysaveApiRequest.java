package com.project.triple.model.network.request;

import com.project.triple.model.enumclass.SaveType;
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
    private Long userId;
    private Long itemNum;
    private String saveYn;
    private String memo;
    private SaveType saveType;
    private LocalDateTime regDate;
    private String location;
    private String title;
    private String summary;
    private String uploadPath;
}
