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
    private String roomNum;
    private String roomType;
    private LodgingRoomStatus revStatus;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String width;
    private Integer roomCapacity;
    private String roomPolicy;
    private BigDecimal price;
    private Long lodgingId;
    private LocalDateTime useDate;
    private LodgingRoomStatus status;
}

