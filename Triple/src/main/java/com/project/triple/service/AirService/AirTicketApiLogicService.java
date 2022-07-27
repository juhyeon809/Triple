package com.project.triple.service.AirService;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.enumclass.TicketStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirTicketApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.repository.AirTicketRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirTicketApiLogicService extends BaseService<AirTicketApiRequest, AirTicketApiResponse, AirTicket> {

    @Autowired
    private AirTicketRepository airTicketRepository;

    private AirTicketApiResponse response(AirTicket airticket){
        AirTicketApiResponse airTicketApiResponse = AirTicketApiResponse.builder()
                .idx(airticket.getIdx())
                .ticketType(airticket.getTicketType())
                .ticketNum(airticket.getTicketNum())
                .departureAirport(airticket.getDepartureAirport())
                .landingAirport(airticket.getLandingAirport())
                .departureDate(airticket.getDepartureDate())
                .landingDate(airticket.getLandingDate())
                .price(airticket.getPrice())
                .seatNum(airticket.getSeatNum())
                .seatGrade(airticket.getSeatGrade())
                .baggage(airticket.getBaggage())
                .revDate(airticket.getRevDate())
                .status(airticket.getStatus())
                .build();


        return airTicketApiResponse;
    }

    @Override
    public Header<AirTicketApiResponse> create(Header<AirTicketApiRequest> request) {
        AirTicketApiRequest airTicketApiRequest = request.getData();
        AirTicket airTicket = AirTicket.builder().ticketType(airTicketApiRequest.getTicketType())
                .ticketNum(airTicketApiRequest.getTicketNum())
                .departureAirport(airTicketApiRequest.getDepartureAirport())
                .landingAirport(airTicketApiRequest.getLandingAirport())
                .departureDate(airTicketApiRequest.getDepartureDate())
                .landingDate(airTicketApiRequest.getLandingDate())
                .price(airTicketApiRequest.getPrice())
                .seatNum(airTicketApiRequest.getSeatNum())
                .seatGrade(airTicketApiRequest.getSeatGrade())
                .baggage(airTicketApiRequest.getBaggage())
                .revDate(airTicketApiRequest.getRevDate())
                .status(TicketStatus.AVAILABLE)
                .build();
        AirTicket newAirTicket = baseRepository.save(airTicket);
        return Header.OK(response(newAirTicket));
    }

    @Override
    public Header<AirTicketApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<AirTicketApiResponse> update(Header<AirTicketApiRequest> request) {
        return null;
    }

    @Override
    public Header<AirTicketApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<AirTicketApiResponse>> search(){
        List<AirTicket> airTicketList = airTicketRepository.findAll();
        List<AirTicketApiResponse> airTicketApiResponseList = airTicketList.stream()
                .map(airTicket -> response(airTicket))
                .collect(Collectors.toList());
        return Header.OK(airTicketApiResponseList);
    }
}
