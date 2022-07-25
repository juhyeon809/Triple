package com.project.triple.service;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.TourTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.TourTicketApiRequest;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.model.network.response.TourTicketApiResponse;
import com.project.triple.repository.TourTicketRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class TourTicketApiLogicService extends BaseService<TourTicketApiRequest, TourTicketApiResponse, TourTicket> {

    @Autowired
    private TourTicketRepository tourTicketRepository;

    private TourTicketApiResponse response(TourTicket tourTicket){
        TourTicketApiResponse tourTicketApiResponse = TourTicketApiResponse.builder()
                .idx(tourTicket.getIdx())
                .ticketType(tourTicket.getTicketType())
                .ticketNum(tourTicket.getTicketNum())
                .revName(tourTicket.getRevName())
                .revHp(tourTicket.getRevHp())
                .revEmail(tourTicket.getRevEmail())
                .repreHp(tourTicket.getRepreHp())
                .repreLastname(tourTicket.getRepreLastname())
                .repreFirstname(tourTicket.getRepreFirstname())
                .repreBirth(tourTicket.getRepreBirth())
                .kakaoid(tourTicket.getKakaoid())
                .lodgingName(tourTicket.getLodgingName())
                .useLastname(tourTicket.getUseLastname())
                .useFirstname(tourTicket.getUseFirstname())
                .regDate(tourTicket.getRegDate())
                .build();
        return tourTicketApiResponse;
    }

    @Override
    public Header<TourTicketApiResponse> create(Header<TourTicketApiRequest> request) {
        return null;
    }

    @Override
    public Header<TourTicketApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TourTicketApiResponse> update(Header<TourTicketApiRequest> request) {
        return null;
    }

    @Override
    public Header<TourTicketApiResponse> delete(Long id) {
        return null;
    }
}
