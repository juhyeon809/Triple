package com.project.triple.service;

import com.project.triple.model.entity.TourTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.TourTicketApiRequest;
import com.project.triple.model.network.response.LodgingResponse.LodgingTicketApiResponse;
import com.project.triple.model.network.response.TourTicketApiResponse;
import com.project.triple.repository.TourTicketRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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

    public String findAllTicketNum(String tNum){
        String ticketNum = tourTicketRepository.findAllByTicketNum(tNum).get().getTicketNum();

        return ticketNum;
    }

//    public Header<List<TourTicketApiResponse>> search2(Long idx){
//        List<TourTicketApiResponse> tourTicketList = tourTicketRepository.findByIdx(idx).stream()
//    public Header<List<TourTicketApiResponse>> search2(String ticketNum){
//        List<TourTicketApiResponse> tourTicketList = tourTicketRepository.findByTicketNum(ticketNum).stream()
//                .map(lodgingTicket -> response(lodgingTicket)).collect(Collectors.toList());
//        return Header.OK(tourTicketList);
//    }
}
