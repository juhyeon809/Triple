package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Air.Aircraft;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AircraftApiRequest;
import com.project.triple.model.network.request.AirRequest.AirportApiRequest;
import com.project.triple.model.network.response.AirResponse.AircraftApiResponse;
import com.project.triple.model.network.response.AirResponse.AirportApiResponse;
import com.project.triple.service.AirService.AircraftApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/aircraft")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class AircraftApiController extends CrudController<AircraftApiRequest, AircraftApiResponse, Aircraft> {

    private final AircraftApiLogicService aircraftApiLogicService;

    @PostMapping("/register")
    public Header<AirportApiResponse> create(AircraftApiRequest request, HttpServletResponse response) throws IOException {
        aircraftApiLogicService.create(Header.OK(request));
        ScriptUtils.alertAndMovePage(response,"항공기 등록완료!","/Triple/airportList");

        return null;
    }
}
