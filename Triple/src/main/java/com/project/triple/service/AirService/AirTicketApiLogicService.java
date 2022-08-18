package com.project.triple.service.AirService;

import com.project.triple.controller.page.TimeCollector;
import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Air.Aircraft;
import com.project.triple.model.entity.Air.Airline;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.enumclass.TicketStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirTicketApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.AirResponse.AircraftApiResponse;
import com.project.triple.model.network.response.AirResponse.AirlineApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.repository.AirTicketRepository;
import com.project.triple.repository.AircraftRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirTicketApiLogicService extends BaseService<AirTicketApiRequest, AirTicketApiResponse, AirTicket> {

    @Autowired
    private AirTicketRepository airTicketRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    private AirTicketApiResponse response(AirTicket airticket){
        AirTicketApiResponse airTicketApiResponse = AirTicketApiResponse.builder()
                .idx(airticket.getIdx())
                .airRoute(airticket.getAirRoute())
                .departureAirport(airticket.getDepartureAirport())
                .landingAirport(airticket.getLandingAirport())
                .departureTime(airticket.getDepartureTime())
                .landingTime(airticket.getLandingTime())
                .flightTime(airticket.getFlightTime())
                .airlineName(airticket.getAirlineName())
                .aircraftName(airticket.getAircraftName())
                .baggage(airticket.getBaggage())
                .economyAdultPrice(airticket.getEconomyAdultPrice())
                .economyChildPrice(airticket.getEconomyChildPrice())
                .economyInfantPrice(airticket.getEconomyInfantPrice())
                .premiumAdultPrice(airticket.getPremiumAdultPrice())
                .premiumChildPrice(airticket.getPremiumChildPrice())
                .premiumInfantPrice(airticket.getPremiumInfantPrice())
                .businessAdultPrice(airticket.getBusinessAdultPrice())
                .businessChildPrice(airticket.getBusinessChildPrice())
                .businessInfantPrice(airticket.getBusinessInfantPrice())
                .firstAdultPrice(airticket.getFirstAdultPrice())
                .firstChildPrice(airticket.getFirstChildPrice())
                .firstInfantPrice(airticket.getFirstInfantPrice())
                .premiumSeatCount(airticket.getPremiumSeatCount())
                .firstSeatCount(airticket.getFirstSeatCount())
                .businessSeatCount(airticket.getBusinessSeatCount())
                .economySeatCount(airticket.getEconomySeatCount())
                .regDate(airticket.getRegDate())
                .build();


        return airTicketApiResponse;
    }

    @Override
    public Header<AirTicketApiResponse> create(Header<AirTicketApiRequest> request) {
        return null;
    }

    public Header<AirTicketApiResponse> write(AirTicket airTicket) {
        Aircraft aircraft = aircraftRepository.findByAircraftName(airTicket.getAircraftName());
        airTicket.setPremiumSeatCount(aircraft.getPremiumSeat());
        airTicket.setFirstSeatCount(aircraft.getFirstSeat());
        airTicket.setBusinessSeatCount(aircraft.getBusinessSeat());
        airTicket.setEconomySeatCount(aircraft.getEconomySeat());
        AirTicket newAirTicket = baseRepository.save(airTicket);
        return Header.OK(response(newAirTicket));
    }

    @Override
    public Header<AirTicketApiResponse> read(Long id) {
        return airTicketRepository.findById(id).map(airTicket -> response(airTicket)).map(Header::OK).orElseGet(() -> Header.ERROR("데이터 없음"));
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

    public Header<List<AirTicketApiResponse>> find_by_route(String route){
        List<AirTicketApiResponse> airTicketList = airTicketRepository.findAllByAirRoute(route).stream().map(airTicket -> response(airTicket)).collect(Collectors.toList());

        return Header.OK(airTicketList);
    }

    public Header<List<AirTicketApiResponse>> find_by_departureTime( String departure, String landing, String time){
        List<AirTicketApiResponse> airTicketApiResponse = airTicketRepository.findAllByDepartureAirportAndLandingAirportAndDepartureTimeContaining(departure, landing, time)
                .stream().map(airTicket -> response(airTicket)).collect(Collectors.toList());

        return Header.OK(airTicketApiResponse);
    }


    /*항공권 조회*/
    public Header<List<AirTicketApiResponse>> search_sort(){
        List<AirTicket> airTicketList = airTicketRepository.findAllByOrderByIdxDesc();
        List<AirTicketApiResponse> airTicketApiResponseList = airTicketList.stream()
                .map(airTicket -> response(airTicket))
                .collect(Collectors.toList());
        return Header.OK(airTicketApiResponseList);
    }

    public Header<AirTicketApiResponse> read2(Long departureTicketId){
        AirTicket airTicket = airTicketRepository.findAllByIdx(departureTicketId);

        AirTicketApiResponse airTicketApiResponse = response(airTicket);

        return Header.OK(airTicketApiResponse);
    }

    public String findDepartureAirport(Long idx){
        String departureAirport = airTicketRepository.findByIdx(idx).get().getDepartureAirport();

        return departureAirport;
    }

    public String findLandingAirport(Long idx){
        String landingAirport = airTicketRepository.findByIdx(idx).get().getLandingAirport();

        return landingAirport;
    }
}
