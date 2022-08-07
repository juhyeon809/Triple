package com.project.triple.model.network.response.LodgingResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LodgingTicketApiResponse {
    private Long idx;
    private String ticketType;
    private String ticketNum;
    private String roomNum;
    private String revName;
    private String revHp;
    private String revEmail;
    private String useEngLastname;
    private String useEngFirstname;
    private String useBirth;
    private String useRequests;
    private String infoAgree;
    private LocalDateTime regDate;
    private Long userId;
    private Long guestNum;
    private String transportation;
}
