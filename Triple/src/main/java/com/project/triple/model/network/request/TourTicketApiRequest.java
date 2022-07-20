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
    private Long id;
    private String ticketType;
    private String ticketNum;
    private LocalDateTime regDate;
}
