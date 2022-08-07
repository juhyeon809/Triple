package com.project.triple.model.network.response.ReservationResponse;

import com.project.triple.model.enumclass.ServiceLife;
import com.project.triple.model.enumclass.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationApiResponse {
    private Long idx;
    private TicketType ticketType;
    private String ticketNum;
    private String revName;
    private String email;
    private String hp;
    private String emergencyHp;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime revDate;
    private ServiceLife serviceLife;
}
