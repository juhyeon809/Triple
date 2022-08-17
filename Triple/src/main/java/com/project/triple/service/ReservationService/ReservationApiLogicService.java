package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.TicketType;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.ReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.ReservationApiResponse;
import com.project.triple.model.network.response.UserResponse.UsersApiResponse;
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
                .title(reservation.getTitle())
                .content(reservation.getContent())
                .revDate(reservation.getRevDate())
                .serviceLife(reservation.getServiceLife())
                .build();
        return reservationApiResponse;
    }

    @Override
    public Header<ReservationApiResponse> create(Header<ReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReservationApiResponse> read(Long id) {

        Reservation reservation = reservationRepository.findByIdx(id);

        ReservationApiResponse reservationApiResponse = response(reservation);

        return Header.OK(reservationApiResponse);
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

    public Header<List<ReservationApiResponse>> air(){
        List<ReservationApiResponse> reservationApiResponseList = reservationRepository.findAllByTicketType(TicketType.AIR)
                .stream().map(reservation -> response(reservation)).collect(Collectors.toList());
        return Header.OK(reservationApiResponseList);
    }

    public Header<List<ReservationApiResponse>> lodging(){
        List<ReservationApiResponse> reservationApiResponseList = reservationRepository.findAllByTicketType(TicketType.LODGING)
                .stream().map(reservation -> response(reservation)).collect(Collectors.toList());
        return Header.OK(reservationApiResponseList);
    }

    public Header<List<ReservationApiResponse>> tour(){
        List<ReservationApiResponse> reservationApiResponseList = reservationRepository.findAllByTicketType(TicketType.TOUR)
                .stream().map(reservation -> response(reservation)).collect(Collectors.toList());
        return Header.OK(reservationApiResponseList);
    }

    public Header<ReservationApiResponse> read2(String ticketNum) {

        Reservation reservation = reservationRepository.findByTicketNum(ticketNum);

        ReservationApiResponse reservationApiResponse = response(reservation);

        return Header.OK(reservationApiResponse);
    }
//    public Header<List<ReservationApiResponse>> findTicketNum(Long userId){
//        List<ReservationApiResponse> reservationApiResponseList = reservationRepository.findByUserId(userId).stream()
//                .map(reservation -> response(reservation)).collect(Collectors.toList());
//        return Header.OK(reservationApiResponseList);
//    }

    /*예약 조회*/
    public Header<List<ReservationApiResponse>> search(){
        List<Reservation> reservationList = reservationRepository.findAllByOrderByIdxDesc();
        List<ReservationApiResponse> reservationApiResponseList = reservationList.stream()
                .map(reservation -> response(reservation))
                .collect(Collectors.toList());
        return Header.OK(reservationApiResponseList);
    }


}
