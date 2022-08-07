package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Air.Airport;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirportApiRequest;
import com.project.triple.model.network.response.AirResponse.AirportApiResponse;
import com.project.triple.service.AirService.AirportApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/airport")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class AirportApiController extends CrudController<AirportApiRequest, AirportApiResponse, Airport> {

    private final AirportApiLogicService airportApiLogicService;

    @PostMapping("/register")
    public Header<AirportApiResponse> create(AirportApiRequest request, HttpServletResponse response) throws IOException {
        airportApiLogicService.create(Header.OK(request));
        ScriptUtils.alertAndMovePage(response,"취항지 등록완료!","/Triple/airportList");

        return null;
    }
}
