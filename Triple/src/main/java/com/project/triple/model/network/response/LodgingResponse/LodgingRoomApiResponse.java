package com.project.triple.model.network.response.LodgingResponse;

import com.project.triple.model.enumclass.LodgingRoomStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LodgingRoomApiResponse {
    private Long idx;
    private Long companyId;
    private String name;
    private String roomNum;
    private String uploadPath;
    private String fileName;
    private String roomCapacity;
    private String smoking;
    private String roomView;
    private String width;
    private String bed;
    private String introducing;
    private Integer price;
    private Integer likeCount;;
    private LodgingRoomStatus status;
}

