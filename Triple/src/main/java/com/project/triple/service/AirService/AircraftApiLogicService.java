package com.project.triple.service.AirService;

import com.project.triple.model.entity.Air.Aircraft;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AircraftApiRequest;
import com.project.triple.model.network.response.AirResponse.AircraftApiResponse;
import com.project.triple.repository.AircraftRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AircraftApiLogicService extends BaseService<AircraftApiRequest, AircraftApiResponse, Aircraft> {

    @Autowired
    private AircraftRepository aircraftRepository;

    private AircraftApiResponse response(Aircraft aircraft){
        AircraftApiResponse aircraftApiResponse = AircraftApiResponse.builder()
                .idx(aircraft.getIdx())
                .aircraftName(aircraft.getAircraftName())
                .madeBy(aircraft.getMadeBy())
                .aircraftCapacity(aircraft.getAircraftCapacity())
                .premiumSeat(aircraft.getPremiumSeat())
                .firstSeat(aircraft.getFirstSeat())
                .businessSeat(aircraft.getBusinessSeat())
                .economySeat(aircraft.getEconomySeat())
                .airlineName(aircraft.getAirlineName())
                .build();
        return aircraftApiResponse;
    }

    @Override
    public Header<AircraftApiResponse> create(Header<AircraftApiRequest> request) {
        AircraftApiRequest aircraftApiRequest = request.getData();
        Aircraft aircraft = Aircraft.builder()
                .aircraftName(aircraftApiRequest.getAircraftName())
                .madeBy(aircraftApiRequest.getMadeBy())
                .aircraftCapacity(aircraftApiRequest.getAircraftCapacity())
                .premiumSeat(aircraftApiRequest.getPremiumSeat())
                .firstSeat(aircraftApiRequest.getFirstSeat())
                .businessSeat(aircraftApiRequest.getBusinessSeat())
                .economySeat(aircraftApiRequest.getEconomySeat())
                .airlineName(aircraftApiRequest.getAirlineName())
                .build();
        Aircraft newAircraft = baseRepository.save(aircraft);

        return Header.OK(response(newAircraft));

    }

    @Override
    public Header<AircraftApiResponse> read(Long id) {
        return baseRepository.findById(id).map(aircraft -> response(aircraft)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AircraftApiResponse> update(Header<AircraftApiRequest> request) {
        AircraftApiRequest aircraftApiRequest = request.getData();
        Optional<Aircraft> aircraft = baseRepository.findById(aircraftApiRequest.getIdx());

        return aircraft.map(
                aircraft1 -> {
                    aircraft1.setAircraftName(aircraftApiRequest.getAircraftName());
                    aircraft1.setMadeBy(aircraftApiRequest.getMadeBy());
                    aircraft1.setAircraftCapacity(aircraftApiRequest.getAircraftCapacity());
                    aircraft1.setPremiumSeat(aircraftApiRequest.getPremiumSeat());
                    aircraft1.setFirstSeat(aircraftApiRequest.getFirstSeat());
                    aircraft1.setBusinessSeat(aircraftApiRequest.getBusinessSeat());
                    aircraft1.setEconomySeat(aircraftApiRequest.getEconomySeat());
                    aircraft1.setAirlineName(aircraftApiRequest.getAirlineName());
                    return aircraft1;
                }).map(aircraft1 -> baseRepository.save(aircraft1)).map(aircraft1 -> response(aircraft1)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Aircraft> aircraft = baseRepository.findById(id);
        return aircraft.map(aircraft1 -> {
            baseRepository.delete(aircraft1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public Header<List<AircraftApiResponse>> search_by_name(String name){

        return Header.OK(aircraftRepository.findAllByAirlineName(name).stream().map(aircraft -> response(aircraft)).collect(Collectors.toList()));
    }
}
