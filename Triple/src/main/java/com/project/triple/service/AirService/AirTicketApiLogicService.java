package com.project.triple.service.AirService;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirTicketApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.repository.AirTicketRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirTicketApiLogicService extends BaseService<AirTicketApiRequest, AirTicketApiResponse, AirTicket> {

    @Autowired
    private AirTicketRepository airTicketRepository;

    private AirTicketApiResponse response(AirTicket airticket){
        AirTicketApiResponse airTicketApiResponse = AirTicketApiResponse.builder()
                .id(airticket.getId())
                .ticketType(airticket.getTicketType())
                .ticketNum(airticket.getTicketNum())
                .airlineId(airticket.getAirlineId())
                .aircraftId(airticket.getAircraftId())
                .departureAirport(airticket.getDepartureAirport())
                .landingAirport(airticket.getLandingAirport())
                .departureDate(airticket.getDepartureDate())
                .landingDate(airticket.getLandingDate())
                .price(airticket.getPrice())
                .seatNum(airticket.getSeatNum())
                .seatGrade(airticket.getSeatGrade())
                .baggage(airticket.getBaggage())
                .build();


        return airTicketApiResponse;
    }

    @Override
    public Header<AirTicketApiResponse> create(Header<AirTicketApiRequest> request) {
        return null;
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
}
