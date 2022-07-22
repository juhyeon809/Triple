package com.project.triple.model.network.request;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourTicketApiRequest {
    private Long idx;
    private String ticketType;
    private String ticketNum;
    private String revName;
    private String revHp;
    private String revEmail;
    private String repreHp;
    private String repreLastname;
    private String repreFirstname;
    private String repreBirth;
    private String kakaoid;
    private String lodgingName;
    private String useLastname;
    private String useFirstname;
    private LocalDateTime regDate;
}
