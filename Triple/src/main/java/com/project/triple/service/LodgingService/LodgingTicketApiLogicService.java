package com.project.triple.service.LodgingService;

import com.project.triple.model.entity.Lodging.LodgingTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingTicketApiRequest;
import com.project.triple.model.network.response.LodgingResponse.LodgingTicketApiResponse;
import com.project.triple.repository.LodgingTicketRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
