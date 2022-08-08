package com.project.triple.model.network.request.ReservationRequest;

import com.project.triple.model.enumclass.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundTicketReservationApiRequest {
    private Long idx;
    private String email;
    private Long departureTicketId;
    private Long comebackTicketId;
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
