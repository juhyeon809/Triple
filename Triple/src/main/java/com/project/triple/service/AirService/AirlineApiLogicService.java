package com.project.triple.service.AirService;

import com.project.triple.model.entity.Air.Airline;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirlineApiRequest;
import com.project.triple.model.network.response.AirResponse.AirlineApiResponse;
import com.project.triple.repository.AirlineRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AirlineApiLogicService extends BaseService<AirlineApiRequest, AirlineApiResponse, Airline> {

    @Autowired
    private AirlineRepository airlineRepository;

    private AirlineApiResponse response(Airline airline){
        AirlineApiResponse airlineApiResponse = AirlineApiResponse.builder()
                .id(airline.getId())
                .airlineNum(airline.getAirlineNum())
                .krName(airline.getKrName())
                .enName(airline.getEnName())
                .airlineCode(airline.getAirlineCode())
                .address(airline.getAddress())
                .contactNum1(airline.getContactNum1())
                .contactNum2(airline.getContactNum2())
                .build();
        return airlineApiResponse;
    }
    @Override
    public Header<AirlineApiResponse> create(Header<AirlineApiRequest> request) {
        AirlineApiRequest airlineApiRequest = request.getData();
        Airline airline = Airline.builder().airlineNum(airlineApiRequest.getAirlineNum())
                .krName(airlineApiRequest.getKrName())
                .enName(airlineApiRequest.getEnName())
                .airlineCode(airlineApiRequest.getAirlineCode())
                .address(airlineApiRequest.getAddress())
                .contactNum1(airlineApiRequest.getContactNum1())
                .contactNum2(airlineApiRequest.getContactNum2())
                .build();
        Airline newAirline = baseRepository.save(airline);
        return Header.OK(response(newAirline));
    }

    @Override
    public Header<AirlineApiResponse> read(Long id) {
        return baseRepository.findById(id).map(airline -> response(airline)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AirlineApiResponse> update(Header<AirlineApiRequest> request) {
        AirlineApiRequest airlineApiRequest = request.getData();
        Optional<Airline> airline = baseRepository.findById(airlineApiRequest.getId());

        return null;
    }

    @Override
    public Header<AirlineApiResponse> delete(Long id) {
        return null;
    }
}
