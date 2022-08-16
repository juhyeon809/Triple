package com.project.triple.service.AirService;


import com.project.triple.model.entity.Air.Airport;
import com.project.triple.model.entity.Lodging.LodgingTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirportApiRequest;
import com.project.triple.model.network.response.AirResponse.AirportApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingTicketApiResponse;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirportApiRequest;
import com.project.triple.model.network.response.AirResponse.AirportApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.repository.AirportRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportApiLogicService extends BaseService<AirportApiRequest, AirportApiResponse, Airport> {

    @Autowired
    private AirportRepository airportRepository;

    private AirportApiResponse response(Airport airport){
        AirportApiResponse airportApiResponse = AirportApiResponse.builder()
                .idx(airport.getIdx())
                .airportName(airport.getAirportName())
                .country(airport.getCountry())
                .city(airport.getCity())
                .build();

        return airportApiResponse;
    }

    @Override
    public Header<AirportApiResponse> create(Header<AirportApiRequest> request) {
        AirportApiRequest airportApiRequest = request.getData();
        Airport airport = Airport.builder()
                .airportName(airportApiRequest.getAirportName())
                .country(airportApiRequest.getCountry())
                .city(airportApiRequest.getCity())
                .build();
        Airport newAirport = baseRepository.save(airport);
        return Header.OK(response(newAirport));
    }

    @Override
    public Header<AirportApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<AirportApiResponse> update(Header<AirportApiRequest> request) {
        return null;
    }

    @Override
    public Header<AirportApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<AirportApiResponse>> list(){
      return Header.OK(airportRepository.findAll().stream().map(airport -> response(airport)).collect(Collectors.toList()));
    }

    public String findCity(String airportName){
        String city = airportRepository.findByAirportName(airportName).get().getCity();

        return city;
    }

    /*관리자 조회*/
    public Header<List<AirportApiResponse>> search(){
        List<Airport> airportList = airportRepository.findAllByOrderByIdxDesc();
        List<AirportApiResponse> airportApiResponseList = airportList.stream()
                .map(airport -> response(airport))
                .collect(Collectors.toList());
        return Header.OK(airportApiResponseList);
    }
}
