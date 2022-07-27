package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.ReservationAiruse;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.ReservationAiruseApiRequest;
import com.project.triple.model.network.response.ReservationResponse.ReservationAiruseApiResponse;
import com.project.triple.repository.ReservationAiruseRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationAiruseApiLogicService extends BaseService<ReservationAiruseApiRequest, ReservationAiruseApiResponse, ReservationAiruse> {

    @Autowired
    private ReservationAiruseRepository reservationAiruseRepository;

    private ReservationAiruseApiResponse response(ReservationAiruse reservationAiruse){
        ReservationAiruseApiResponse reservationAiruseApiResponse = ReservationAiruseApiResponse.builder()
                .idx(reservationAiruse.getIdx())
                .ticketType(reservationAiruse.getTicketType())
                .ticketNum(reservationAiruse.getTicketNum())
                .engLastname(reservationAiruse.getEngLastname())
                .engFirstname(reservationAiruse.getEngFirstname())
                .birth(reservationAiruse.getBirth())
                .gender(reservationAiruse.getGender())
                .useHp(reservationAiruse.getUseHp())
                .nationality(reservationAiruse.getNationality())
                .passportNum(reservationAiruse.getPassportNum())
                .passportExp(reservationAiruse.getPassportExp())
                .passportCount(reservationAiruse.getPassportCount())
                .infoAgree(reservationAiruse.getInfoAgree())
                .regDate(reservationAiruse.getRegDate())
                .userId(reservationAiruse.getUsers().getIdx())
                .build();
        return reservationAiruseApiResponse;
    }

    @Override
    public Header<ReservationAiruseApiResponse> create(Header<ReservationAiruseApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReservationAiruseApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ReservationAiruseApiResponse> update(Header<ReservationAiruseApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReservationAiruseApiResponse> delete(Long id) {
        return null;
    }
}
