package com.project.triple.service.ReservationService;

import com.project.triple.model.entity.Reservation.OnewayReservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.OnewayReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.OnewayReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.repository.OnewayReservationRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OnewayReservationApiLogicService extends BaseService<OnewayReservationApiRequest, OnewayReservationApiResponse, OnewayReservation> {

    @Autowired
    private OnewayReservationRepository onewayReservationRepository;

    private OnewayReservationApiResponse response(OnewayReservation onewayReservation){
        OnewayReservationApiResponse onewayReservationApiResponse = OnewayReservationApiResponse.builder()
                .idx(onewayReservation.getIdx())
                .email(onewayReservation.getEmail())
                .departureTicketId(onewayReservation.getDepartureTicketId())
                .ageType(onewayReservation.getAgeType())
                .engLastname(onewayReservation.getEngLastname())
                .engFirstname(onewayReservation.getEngFirstname())
                .birth(onewayReservation.getBirth())
                .gender(onewayReservation.getGender())
                .useHp(onewayReservation.getUseHp())
                .nationality(onewayReservation.getNationality())
                .passportNum(onewayReservation.getPassportNum())
                .passportExp(onewayReservation.getPassportExp())
                .passportCountry(onewayReservation.getPassportCountry())
                .regDate(onewayReservation.getRegDate())
                .passengerName(onewayReservation.getPassengerName())
                .build();
        return onewayReservationApiResponse;
    }

    @Override
    public Header<OnewayReservationApiResponse> create(Header<OnewayReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<OnewayReservationApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<OnewayReservationApiResponse> update(Header<OnewayReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long idx) {
        Optional<OnewayReservation> onewayReservation = baseRepository.findById(idx);
        return onewayReservation.map(onewayReservation1 -> {
            baseRepository.delete(onewayReservation1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public Header<List<OnewayReservationApiResponse>> reservation(List<OnewayReservation> onewayReservationList){
        List<OnewayReservationApiResponse> onewayReservationApiResponses = new ArrayList<>();
        for(OnewayReservation onewayReservation : onewayReservationList){
            OnewayReservation onewayReservation1 = baseRepository.save(onewayReservation);
            onewayReservationApiResponses.add(response(onewayReservation1));
        }

        return Header.OK(onewayReservationApiResponses);
    }

    public Long findDeparture(String email){
        Long onewayReservation = onewayReservationRepository.findDepartureTicketId(email).get().getDepartureTicketId();

        return onewayReservation;

    }

    public Header<OnewayReservationApiResponse> read2(String email) {

        OnewayReservation onewayReservation = onewayReservationRepository.findByIdx(email);

        OnewayReservationApiResponse onewayReservationApiResponse = response(onewayReservation);

        return Header.OK(onewayReservationApiResponse);
    }

    public Header<List<OnewayReservationApiResponse>> search(String email){

        List<OnewayReservationApiResponse> onewayReservationApiResponseList = onewayReservationRepository.findAllByEmail(email).stream()
                .map(onewayReservation -> response(onewayReservation)).collect(Collectors.toList());

        return Header.OK(onewayReservationApiResponseList);
    }



    public Header<List<OnewayReservationApiResponse>> list(String email){
        List<OnewayReservation> onewayReservationList = onewayReservationRepository.findAllByEmail(email);
        List<OnewayReservationApiResponse> onewayReservationApiResponseList = onewayReservationList.stream()
                .map(onewayReservation -> response(onewayReservation))
                .collect(Collectors.toList());
        return Header.OK(onewayReservationApiResponseList);
    }

    public Header<List<OnewayReservationApiResponse>> search3(String email){
        List<OnewayReservationApiResponse> onewayReservationApiResponseList = onewayReservationRepository.findByEmailOrderByIdxDesc(email)
                .stream().map(onewayReservation -> response(onewayReservation)).collect(Collectors.toList());

        return Header.OK(onewayReservationApiResponseList);
    }

    public Long classCount(String seatClass){
        Long classCount = onewayReservationRepository.countBySeatClass(seatClass);

        return classCount;
    }


}
