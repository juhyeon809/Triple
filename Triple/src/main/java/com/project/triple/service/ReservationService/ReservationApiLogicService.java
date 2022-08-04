package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.ReservationApiRequest;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.model.network.response.ReservationResponse.ReservationApiResponse;
import com.project.triple.repository.ReservationRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
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
//                .userId(reservation.getUsers().getIdx())
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

    public String findTicketNum(Long userId){
        String ticketNum = reservationRepository.findByUserId(userId).get().getTicketNum();

        return ticketNum;
    }

//    public Header<List<ReservationApiResponse>> findTicketNum(Long userId){
//        List<ReservationApiResponse> reservationApiResponseList = reservationRepository.findByUserId(userId).stream()
//                .map(reservation -> response(reservation)).collect(Collectors.toList());
//        return Header.OK(reservationApiResponseList);
//    }


}
