package com.project.triple.model.network.request.ReservationRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationApiRequest {
    private Long idx;
    private String ticketType;
    private String ticketNum;
    private String revName;
    private String email;
    private String hp;
    private String emergencyHp;
    private Long userId;

}
