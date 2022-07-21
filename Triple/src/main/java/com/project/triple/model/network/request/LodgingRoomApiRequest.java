package com.project.triple.model.network.request;

import com.project.triple.model.enumclass.LodgingRoomStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LodgingRoomApiRequest {
    private Long id;
    private String roomNum;
    private String roomType;
    private LodgingRoomStatus revStatus;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String width;
    private Integer roomCapacity;
    private String roomPolicy;
    private Integer price;
    private Integer lodgingId;
}
