package com.project.triple.model.network.response.ReservationResponse;

import com.project.triple.model.enumclass.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationAiruseApiResponse {
    private Long idx;
//    private Integer userid;
    private String ticketType;
    private Integer ticketNum;
    private String engLastname;
    private String engFirstname;
    private String birth;
    private Gender gender;
    private String useHp;
    private String nationality;
    private String passportNum;
    private String passportExp;
    private String passportCount;
    private String infoAgree;
    private LocalDateTime regDate;
}
