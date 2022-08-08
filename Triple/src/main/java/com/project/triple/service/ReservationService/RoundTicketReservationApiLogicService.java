package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.RoundTicketReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.repository.ReservationAiruseRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationAiruseApiLogicService extends BaseService<RoundTicketReservationApiRequest, RoundTicketReservationApiResponse, RoundTicketReservation> {

    @Autowired
    private ReservationAiruseRepository reservationAiruseRepository;

    private RoundTicketReservationApiResponse response(RoundTicketReservation reservationAiruse){
        RoundTicketReservationApiResponse reservationAiruseApiResponse = RoundTicketReservationApiResponse.builder()
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
    public Header<RoundTicketReservationApiResponse> create(Header<RoundTicketReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<RoundTicketReservationApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<RoundTicketReservationApiResponse> update(Header<RoundTicketReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<RoundTicketReservationApiResponse> delete(Long id) {
        return null;
    }

    public Header<RoundTicketReservationApiResponse> read2(String ticketNum) {

        RoundTicketReservation reservationAiruse = reservationAiruseRepository.findByTicketNum(ticketNum);

        RoundTicketReservationApiResponse reservationAiruseApiResponse = response(reservationAiruse);

        return Header.OK(reservationAiruseApiResponse);
    }
}
