package com.project.triple.service.AirService;


import com.project.triple.model.entity.Air.Airport;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirportApiRequest;
import com.project.triple.model.network.response.AirResponse.AirportApiResponse;
import com.project.triple.repository.AirportRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportApiLogicService extends BaseService<AirportApiRequest, AirportApiResponse, Airport> {

    @Autowired
    private AirportRepository airportRepository;

    private AirportApiResponse response(Airport airport){
        AirportApiResponse airportApiResponse = AirportApiResponse.builder()
                .id(airport.getId())
                .airportNum(airport.getAirportNum())
                .airportName(airport.getAirportName())
                .airportCode(airport.getAirportCode())
                .country(airport.getCountry())
                .city(airport.getCity())
                .build();

        return airportApiResponse;
    }

    @Override
    public Header<AirportApiResponse> create(Header<AirportApiRequest> request) {
        return null;
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
}
