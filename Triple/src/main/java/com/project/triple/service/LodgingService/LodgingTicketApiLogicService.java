package com.project.triple.service.LodgingService;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Lodging.LodgingTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingTicketApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingTicketApiResponse;
import com.project.triple.repository.LodgingTicketRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LodgingTicketApiLogicService extends BaseService<LodgingTicketApiRequest, LodgingTicketApiResponse, LodgingTicket> {

    @Autowired
    private LodgingTicketRepository lodgingTicketRepository;

    private LodgingTicketApiResponse response(LodgingTicket lodgingTicket){
        LodgingTicketApiResponse lodgingTicketApiResponse = LodgingTicketApiResponse.builder()
                .idx(lodgingTicket.getIdx())
                .ticketType(lodgingTicket.getTicketType())
                .ticketNum(lodgingTicket.getTicketNum())
                .roomNum(lodgingTicket.getRoomNum())
                .revName(lodgingTicket.getRevName())
                .revHp(lodgingTicket.getRevHp())
                .revEmail(lodgingTicket.getRevEmail())
                .useEngLastname(lodgingTicket.getUseEngLastname())
                .useEngFirstname(lodgingTicket.getUseEngFirstname())
                .useBirth(lodgingTicket.getUseBirth())
                .useRequests(lodgingTicket.getUseRequests())
                .infoAgree(lodgingTicket.getInfoAgree())
                .regDate(lodgingTicket.getRegDate())
                .userId(lodgingTicket.getUserId())
                .guestNum(lodgingTicket.getGuestNum())
                .transportation(lodgingTicket.getTransportation())
                .build();
        return lodgingTicketApiResponse;
    }

    @Override
    public Header<LodgingTicketApiResponse> create(Header<LodgingTicketApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingTicketApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<LodgingTicketApiResponse> update(Header<LodgingTicketApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingTicketApiResponse> delete(Long id) {
        return null;
    }

    public String findAllTicketNum(String tNum){
        String ticketNum = lodgingTicketRepository.findAllByTicketNum(tNum).get().getTicketNum();

        return ticketNum;
    }



    public Header<List<LodgingTicketApiResponse>> search2(Long idx){
        List<LodgingTicketApiResponse> lodgingTicketList = lodgingTicketRepository.findByIdx(idx).stream()
                .map(lodgingTicket -> response(lodgingTicket)).collect(Collectors.toList());
        return Header.OK(lodgingTicketList);
    }

    public Header<LodgingTicketApiResponse> read2(String ticketNum) {

        LodgingTicket lodgingTicket = lodgingTicketRepository.findByTicketNum(ticketNum);

        LodgingTicketApiResponse lodgingTicketApiResponse = response(lodgingTicket);

        return Header.OK(lodgingTicketApiResponse);
    }

    public String findRoomNum(String ticketNum){
        String roomNum = lodgingTicketRepository.findByTicketNum(ticketNum).getRoomNum();

        return roomNum;
    }

//    public Header<List<LodgingTicketApiResponse>> search2(String ticketNum){
//        List<LodgingTicketApiResponse> lodgingTicketList = lodgingTicketRepository.findByTicketNum(ticketNum).stream()
//                .map(lodgingTicket -> response(lodgingTicket)).collect(Collectors.toList());
//        return Header.OK(lodgingTicketList);
//    }
}
