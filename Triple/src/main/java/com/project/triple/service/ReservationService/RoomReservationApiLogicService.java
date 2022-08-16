package com.project.triple.service.ReservationService;


import com.project.triple.model.entity.Reservation.OnewayReservation;
import com.project.triple.model.entity.Reservation.RoomReservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.RoomReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.OnewayReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoomReservationApiResponse;
import com.project.triple.repository.RoomReservationRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    public List<RoomReservationApiResponse> list(Long roomId){
       return roomReservationRepository.findAllByRoomId(roomId).stream().map(roomReservation -> response(roomReservation)).collect(Collectors.toList());
    }

}
