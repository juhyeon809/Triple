package com.project.triple.controller.page;

import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultiRowRoundTicketReservation {

    private List<RoundTicketReservation> infoList;

}
