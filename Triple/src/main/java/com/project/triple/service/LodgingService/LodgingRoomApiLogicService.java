package com.project.triple.service.LodgingService;

import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingRoomApiRequest;
import com.project.triple.model.network.response.LodgingResponse.LodgingRoomApiResponse;
import com.project.triple.repository.LodgingRoomRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class LodgingRoomApiLogicService extends BaseService<LodgingRoomApiRequest, LodgingRoomApiResponse, LodgingRoom> {

    @Autowired
    private LodgingRoomRepository lodgingRoomRepository;

    private LodgingRoomApiResponse response(LodgingRoom lodgingRoom){
        LodgingRoomApiResponse lodgingRoomApiResponse = LodgingRoomApiResponse.builder()
                .idx(lodgingRoom.getIdx())
                .roomNum(lodgingRoom.getRoomNum())
                .roomType(lodgingRoom.getRoomType())
                .revStatus(lodgingRoom.getRevStatus())
                .checkIn(lodgingRoom.getCheckIn())
                .checkOut(lodgingRoom.getCheckOut())
                .width(lodgingRoom.getWidth())
                .roomCapacity(lodgingRoom.getRoomCapacity())
                .roomPolicy(lodgingRoom.getRoomPolicy())
                .price(lodgingRoom.getPrice())
                .lodgingId(lodgingRoom.getLodgingId())
                .build();
        return lodgingRoomApiResponse;
    }


    @Override
    public Header<LodgingRoomApiResponse> create(Header<LodgingRoomApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingRoomApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<LodgingRoomApiResponse> update(Header<LodgingRoomApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingRoomApiResponse> delete(Long id) {
        return null;
    }
}
