package com.project.triple.model.network.response.ReservationResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationApiResponse {
    private Long id;
    private String ticketType;
    private String ticketNum;
    private String revName;
    private String email;
    private String hp;
    private String emergencyHp;

}
