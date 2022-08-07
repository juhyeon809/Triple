package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Reservation.ReservationAiruse;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.ReservationAiruseApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.ReservationResponse.ReservationAiruseApiResponse;
import com.project.triple.repository.ReservationAiruseRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
                .passportCountry(reservationAiruse.getPassportCountry())
                .infoAgree(reservationAiruse.getInfoAgree())
                .regDate(reservationAiruse.getRegDate())
                .passengerName(reservationAiruse.getPassengerName())
                .userId(reservationAiruse.getIdx())
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

    public Header<ReservationAiruseApiResponse> read2(String ticketNum) {

        ReservationAiruse reservationAiruse = reservationAiruseRepository.findByTicketNum(ticketNum);

        ReservationAiruseApiResponse reservationAiruseApiResponse = response(reservationAiruse);

        return Header.OK(reservationAiruseApiResponse);
    }
}
