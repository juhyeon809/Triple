package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.ReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.ReservationApiResponse;
import com.project.triple.repository.ReservationRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationApiLogicService extends BaseService<ReservationApiRequest, ReservationApiResponse, Reservation> {

    @Autowired
    private ReservationRepository reservationRepository;

    private ReservationApiResponse response(Reservation reservation){
        ReservationApiResponse reservationApiResponse = ReservationApiResponse.builder()
                .idx(reservation.getIdx())
                .ticketType(reservation.getTicketType())
                .ticketNum(reservation.getTicketNum())
                .revName(reservation.getRevName())
                .email(reservation.getEmail())
                .hp(reservation.getHp())
                .emergencyHp(reservation.getEmergencyHp())
                .build();
        return reservationApiResponse;
    }

    @Override
    public Header<ReservationApiResponse> create(Header<ReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReservationApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ReservationApiResponse> update(Header<ReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReservationApiResponse> delete(Long id) {
        return null;
    }
}
