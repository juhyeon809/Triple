package com.project.triple.triple.repository;

import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.service.AirService.AirTicketApiLogicService;
import com.project.triple.triple.TripleApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AirTicketRepositoryTest extends TripleApplicationTests {

    @Autowired
    private AirTicketApiLogicService airTicketApiLogicService;

    @Test
    public void search(){
        List<AirTicketApiResponse> airTicketApiResponseList = airTicketApiLogicService.find_by_departureTime("인천공항", "나리타공항", "2022-08-07").getData();
        for(AirTicketApiResponse airTicketApiResponse : airTicketApiResponseList){
            System.out.println(airTicketApiResponse.getIdx());
            System.out.println(airTicketApiResponse.getAirRoute());
            System.out.println(airTicketApiResponse.getAircraftName());
        }
    }
}
