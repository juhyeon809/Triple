package com.project.triple.model.network.request.ReservationRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnewayReservationApiRequest {
    private Long idx;
    private String email;
    private Long departureTicketId;
    private String ageType;
    private String seatClass;
    private String engLastname;
    private String engFirstname;
    private String birth;
    private String gender;
    private String useHp;
    private String nationality;
    private String passportNum;
    private String passportExp;
    private String passportCountry;
    private String passengerName;
    private LocalDateTime regDate;
}
