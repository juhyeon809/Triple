package com.project.triple.controller.page;


import com.project.triple.model.entity.Reservation.OnewayReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultiRowOnewayReservation {

    private List<OnewayReservation> infoList;
}
