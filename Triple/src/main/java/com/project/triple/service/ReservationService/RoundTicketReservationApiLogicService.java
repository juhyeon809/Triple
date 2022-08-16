package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.RoundTicketReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.repository.RoundTicketReservationRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoundTicketReservationApiLogicService extends BaseService<RoundTicketReservationApiRequest, RoundTicketReservationApiResponse, RoundTicketReservation> {

    @Autowired
    private RoundTicketReservationRepository roundTicketReservationRepository;

    private RoundTicketReservationApiResponse response(RoundTicketReservation reservationAiruse){
        RoundTicketReservationApiResponse reservationAiruseApiResponse = RoundTicketReservationApiResponse.builder()
                .idx(reservationAiruse.getIdx())
                .email(reservationAiruse.getEmail())
                .departureTicketId(reservationAiruse.getDepartureTicketId())
                .comebackTicketId(reservationAiruse.getComebackTicketId())
                .ageType(reservationAiruse.getAgeType())
                .engLastname(reservationAiruse.getEngLastname())
                .engFirstname(reservationAiruse.getEngFirstname())
                .birth(reservationAiruse.getBirth())
                .gender(reservationAiruse.getGender())
                .useHp(reservationAiruse.getUseHp())
                .nationality(reservationAiruse.getNationality())
                .passportNum(reservationAiruse.getPassportNum())
                .passportExp(reservationAiruse.getPassportExp())
                .passportCountry(reservationAiruse.getPassportCountry())
                .regDate(reservationAiruse.getRegDate())
                .passengerName(reservationAiruse.getPassengerName())
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

    public Header<List<RoundTicketReservationApiResponse>> reservation(List<RoundTicketReservation> roundTicketReservationList){
            List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = new ArrayList<>();
            for(RoundTicketReservation roundTicketReservation : roundTicketReservationList){
                RoundTicketReservation roundTicketReservation1 = baseRepository.save(roundTicketReservation);
                roundTicketReservationApiResponseList.add(response(roundTicketReservation1));
            }

            return Header.OK(roundTicketReservationApiResponseList);
    }


    /* 항공예약티켓 조회 */
    public Header<List<RoundTicketReservationApiResponse>> search(){
        List<RoundTicketReservation> RoundTicketList = roundTicketReservationRepository.findAllByOrderByIdxDesc();
        List<RoundTicketReservationApiResponse> roundTicketApiResponseList = RoundTicketList.stream()
                .map(roundTicket -> response(roundTicket))
                .collect(Collectors.toList());
        return Header.OK(roundTicketApiResponseList);
    }

}
