package com.project.triple.model.network.request.ReservationRequest;

import com.project.triple.model.enumclass.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationAiruseApiRequest {
    private Long idx;
    private Long userId;
    private String ticketType;
    private String ticketNum;
    private String engLastname;
    private String engFirstname;
    private String birth;
    private Gender gender;
    private String useHp;
    private String nationality;
    private String passportNum;
    private String passportExp;
    private String passportCountry;
    private String infoAgree;
    private LocalDateTime regDate;
    private String passengerName;
}
