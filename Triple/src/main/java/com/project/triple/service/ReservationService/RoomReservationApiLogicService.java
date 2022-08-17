package com.project.triple.service.ReservationService;


import com.project.triple.model.entity.Reservation.OnewayReservation;
import com.project.triple.model.entity.Reservation.RoomReservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.RoomReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.OnewayReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoomReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.repository.RoomReservationRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomReservationApiLogicService extends BaseService<RoomReservationApiRequest, RoomReservationApiResponse, RoomReservation> {


    @Autowired
    private RoomReservationRepository roomReservationRepository;

    private RoomReservationApiResponse response(RoomReservation roomReservation){
        RoomReservationApiResponse roomReservationApiResponse = RoomReservationApiResponse.builder()
                .idx(roomReservation.getIdx())
                .roomId(roomReservation.getRoomId())
                .userEmail(roomReservation.getUserEmail())
                .startDate(roomReservation.getStartDate())
                .endDate(roomReservation.getEndDate())
                .lastName(roomReservation.getLastName())
                .firstName(roomReservation.getFirstName())
                .birth(roomReservation.getBirth())
                .gender(roomReservation.getGender())
                .request(roomReservation.getRequest())
                .totalPrice(roomReservation.getTotalPrice())
                .regDate(roomReservation.getRegDate())
                .build();
        return roomReservationApiResponse;
    }


    @Override
    public Header<RoomReservationApiResponse> create(Header<RoomReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<RoomReservationApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<RoomReservationApiResponse> update(Header<RoomReservationApiRequest> request) {
        return null;
    }

    @Override
    public Header<RoomReservationApiResponse> delete(Long id) {
        RoomReservation roomReservation = roomReservationRepository.findByIdx(id);
        baseRepository.delete(roomReservation);
        return Header.OK(response(roomReservation));
    }


    public Header delete2(Long idx) {
        Optional<RoomReservation> roomReservation = baseRepository.findById(idx);
        return roomReservation.map(roomReservation1 -> {
            baseRepository.delete(roomReservation1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public List<RoomReservationApiResponse> list(Long roomId){
       return roomReservationRepository.findAllByRoomId(roomId).stream().map(roomReservation -> response(roomReservation)).collect(Collectors.toList());
    }

    public Header<List<RoomReservationApiResponse>> search(String email){
        List<RoomReservationApiResponse> roomReservationApiResponseList = roomReservationRepository.findByUserEmailOrderByIdxDesc(email)
                .stream().map(roomReservation -> response(roomReservation)).collect(Collectors.toList());

        return Header.OK(roomReservationApiResponseList);
    }

    public Header<RoomReservationApiResponse> read2(Long idx) {

        RoomReservation roomReservation = roomReservationRepository.findByIdx(idx);

        RoomReservationApiResponse roomReservationApiResponse = response(roomReservation);

        return Header.OK(roomReservationApiResponse);
    }

    public Header<List<RoomReservationApiResponse>> list2(String email){
        List<RoomReservation> roomReservationList = roomReservationRepository.findAllByUserEmail(email);
        List<RoomReservationApiResponse> roomReservationApiResponseList = roomReservationList.stream()
                .map(roomReservation -> response(roomReservation))
                .collect(Collectors.toList());
        return Header.OK(roomReservationApiResponseList);
    }
    public Header<RoomReservationApiResponse> register(RoomReservation roomReservation){
        RoomReservationApiResponse roomReservationApiResponse = response(baseRepository.save(roomReservation));
        return Header.OK(roomReservationApiResponse);
    }

}
