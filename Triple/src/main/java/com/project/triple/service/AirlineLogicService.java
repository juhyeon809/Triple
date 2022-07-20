package com.project.triple.service;

import com.project.triple.model.entity.Airline;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirlineApiRequest;
import com.project.triple.model.network.response.AirlineApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirlineLogicService extends BaseService<AirlineApiRequest, AirlineApiResponse, Airline>{

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
        return null;
    }

    @Override
    public Header<AirlineApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<AirlineApiResponse> update(Header<AirlineApiRequest> request) {
        return null;
    }

    @Override
    public Header<AirlineApiResponse> delete(Long id) {
        return null;
    }
}
