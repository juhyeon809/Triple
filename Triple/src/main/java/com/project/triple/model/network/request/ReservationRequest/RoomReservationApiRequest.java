package com.project.triple.model.network.request.ReservationRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomReservationApiRequest {
    private Long idx;
    private Long roomId;
    private String userEmail;
    private String startDate;
    private String endDate;
    private String lastName;
    private String firstName;
    private String birth;
    private String gender;
    private String request;
    private Integer totalPrice;
    private LocalDateTime regDate;
}
