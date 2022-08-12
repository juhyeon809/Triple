package com.project.triple.service.AirService;

import com.project.triple.model.entity.Air.Airline;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Reservation.Reservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirlineApiRequest;
import com.project.triple.model.network.response.AirResponse.AirlineApiResponse;
import com.project.triple.model.network.response.ReservationResponse.ReservationApiResponse;
import com.project.triple.repository.AirlineRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AirlineApiLogicService extends BaseService<AirlineApiRequest, AirlineApiResponse, Airline> {

    @Autowired
    private AirlineRepository airlineRepository;

    private AirlineApiResponse response(Airline airline){
        AirlineApiResponse airlineApiResponse = AirlineApiResponse.builder()
                .idx(airline.getIdx())
                .krName(airline.getKrName())
                .enName(airline.getEnName())
                .repNum(airline.getRepNum())
                .route(airline.getRoute())
                .uploadPath(airline.getUploadPath())
                .fileName(airline.getFileName())
                .supportNum(airline.getSupportNum())
                .build();
        return airlineApiResponse;
    }
    @Override
    public Header<AirlineApiResponse> create(Header<AirlineApiRequest> request) {
        AirlineApiRequest airlineApiRequest = request.getData();
        Airline airline = Airline.builder()
                .krName(airlineApiRequest.getKrName())
                .enName(airlineApiRequest.getEnName())
                .route(airlineApiRequest.getRoute())
                .repNum(airlineApiRequest.getRepNum())
                .supportNum(airlineApiRequest.getSupportNum())
                .fileName(airlineApiRequest.getFileName())
                .uploadPath(airlineApiRequest.getUploadPath())
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
        Optional<Airline> airline = baseRepository.findById(airlineApiRequest.getIdx());

        return null;
    }

    public void write(Airline airline, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        airline.setFileName(filename);
        airline.setUploadPath("/files/"+filename);
        airlineRepository.save(airline);
    }

    @Override
    public Header<AirlineApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<AirlineApiResponse>> list() {

        List<AirlineApiResponse> airlineApiResponseList = airlineRepository.findAll().stream().map(airline -> response(airline)).collect(Collectors.toList());
        return Header.OK(airlineApiResponseList);
    }

    /*항공기 조회*/
    public Header<List<AirlineApiResponse>> search(){
        List<Airline> airlineList = airlineRepository.findAllByOrderByIdxDesc();
        List<AirlineApiResponse> airlineApiResponseList = airlineList.stream()
                .map(airline -> response(airline))
                .collect(Collectors.toList());
        return Header.OK(airlineApiResponseList);
    }
}
