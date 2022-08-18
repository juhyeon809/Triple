package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.RoundTicketReservationApiRequest;
import com.project.triple.model.network.response.CouponResponse.CouponApiResponse;
import com.project.triple.model.network.response.ReservationResponse.ReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoomReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.repository.RoundTicketReservationRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                .seatClass(reservationAiruse.getSeatClass())
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


    public Header delete3(Long departureTicketId) {
        Optional<RoundTicketReservation> roundTicketReservation = roundTicketReservationRepository.findByDepartureTicketId(departureTicketId);

        return roundTicketReservation.map(roundTicketReservation1 -> {
            baseRepository.delete(roundTicketReservation1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long idx) {
        Optional<RoundTicketReservation> roundTicketReservation = baseRepository.findById(idx);
        return roundTicketReservation.map(roundTicketReservation1 -> {
            baseRepository.delete(roundTicketReservation1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }



    public Header<List<RoundTicketReservationApiResponse>> reservation(List<RoundTicketReservation> roundTicketReservationList){
        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = new ArrayList<>();
        for(RoundTicketReservation roundTicketReservation : roundTicketReservationList){
            RoundTicketReservation roundTicketReservation1 = baseRepository.save(roundTicketReservation);
            roundTicketReservationApiResponseList.add(response(roundTicketReservation1));
        }

            return Header.OK(roundTicketReservationApiResponseList);
    }

//    public Header<RoundTicketReservationApiResponse> read2(String email){
//        RoundTicketReservation roundTicketReservation = roundTicketReservationRepository.findDepartureTicketId(email);
//
//        RoundTicketReservationApiResponse roundTicketReservationApiResponse = response(roundTicketReservation);
//
//        return Header.OK(roundTicketReservationApiResponse);
//    }

//    public Header<List<RoundTicketReservationApiResponse>> findIdx(String email){
//
//        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationRepository.findDepartureTicketId(email).stream()
//                .map(roundTicketReservation -> response(roundTicketReservation)).collect(Collectors.toList());
//
//        return Header.OK(roundTicketReservationApiResponseList);
//    }

    public Long findDeparture(String email){
        Long roundTicketReservation = roundTicketReservationRepository.findDepartureTicketId(email).get().getDepartureTicketId();

        return roundTicketReservation;

    }

    public Long findComeback(String email){
        Long roundTicketReservation = roundTicketReservationRepository.findDepartureTicketId(email).get().getComebackTicketId();

        return roundTicketReservation;

    }

    public Long findIdx(String email){
        Long roundTicketReservation = roundTicketReservationRepository.findDepartureTicketId(email).get().getIdx();

        return roundTicketReservation;

    }

    public Header<RoundTicketReservationApiResponse> read2(String email) {

        RoundTicketReservation roundTicketReservation = roundTicketReservationRepository.findByEmail(email);

        RoundTicketReservationApiResponse roundTicketReservationApiResponse = response(roundTicketReservation);

        return Header.OK(roundTicketReservationApiResponse);
    }


        public Header<List<RoundTicketReservationApiResponse>> search(String email){

        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationRepository.findAllByEmail(email).stream()
                .map(roundTicketReservation -> response(roundTicketReservation)).collect(Collectors.toList());

        return Header.OK(roundTicketReservationApiResponseList);
    }

    public Long classCount(String seatClass){
        Long classCount = roundTicketReservationRepository.countBySeatClass(seatClass);

        return classCount;
    }

    public String findAgeType(String email){
        String roundTicketReservation = roundTicketReservationRepository.findDepartureTicketId(email).get().getAgeType();

        return roundTicketReservation;

    }

    public Header<RoundTicketReservationApiResponse> update2(RoundTicketReservationApiRequest request) {
        Optional<RoundTicketReservation> roundTicketReservation = baseRepository.findById(request.getIdx());

        return roundTicketReservation.map(
                        roundReservation -> {
                            roundReservation.setDepartureTicketId(request.getDepartureTicketId());
                            return roundReservation;
                        }).map(roundReservation -> baseRepository.save(roundReservation)).map(roundReservation -> response(roundReservation))
                .map(Header::OK).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /* 항공예약티켓 조회 */
    public Header<List<RoundTicketReservationApiResponse>> search2(){
        List<RoundTicketReservation> RoundTicketList = roundTicketReservationRepository.findAllByOrderByIdxDesc();
        List<RoundTicketReservationApiResponse> roundTicketApiResponseList = RoundTicketList.stream()
                .map(roundTicket -> response(roundTicket))
                .collect(Collectors.toList());
        return Header.OK(roundTicketApiResponseList);
    }

//    public Header<RoundTicketReservationApiResponse> search3(Long idx){
//        RoundTicketReservation roundTicketReservation = roundTicketReservationRepository.findByIdx(idx);
//
//        RoundTicketReservationApiResponse roundTicketReservationApiResponse = response(roundTicketReservation);
//
//        return Header.OK(roundTicketReservationApiResponse);
//    }

//    public Header<List<RoundTicketReservationApiResponse>> delete2(Long departureTicketId){
//        List<RoundTicketReservation> RoundTicketList = roundTicketReservationRepository.deleteByDepartureTicketId(departureTicketId);
//        List<RoundTicketReservationApiResponse> roundTicketApiResponseList = RoundTicketList.stream()
//                .map(roundTicket -> response(roundTicket))
//                .collect(Collectors.toList());
//        return Header.OK(roundTicketApiResponseList);
//    }


//    public Header delete2(String email) {
//        Optional<RoundTicketReservation> roundTicketReservation = roundTicketReservationRepository.findByEmailOrderByIdx(email);
//        return roundTicketReservation.map(roundTicketReservation1 -> {
//            baseRepository.delete(roundTicketReservation1);
//            return Header.OK();
//        }).orElseGet(() -> Header.ERROR("데이터 없음"));
//    }

    public Header<List<RoundTicketReservationApiResponse>> list(String email){
        List<RoundTicketReservation> roundTicketReservationList = roundTicketReservationRepository.findAllByEmail(email);
        List<RoundTicketReservationApiResponse> roundTicketApiResponseList = roundTicketReservationList.stream()
                .map(roundTicket -> response(roundTicket))
                .collect(Collectors.toList());
        return Header.OK(roundTicketApiResponseList);
    }
//    public Header<List<RoundTicketReservationApiResponse>> search(String email){
//
//        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationRepository.findAllByEmail(email).stream()
//                .map(roundTicketReservation -> response(roundTicketReservation)).collect(Collectors.toList());
//
//        return Header.OK(roundTicketReservationApiResponseList);
//    }

    public Header<List<RoundTicketReservationApiResponse>> search3(String email){
        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationRepository.findByEmailOrderByIdxDesc(email)
                .stream().map(roundTicketReservation -> response(roundTicketReservation)).collect(Collectors.toList());

        return Header.OK(roundTicketReservationApiResponseList);
    }
}
