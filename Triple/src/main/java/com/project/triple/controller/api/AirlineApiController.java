package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Air.Airline;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirlineApiRequest;
import com.project.triple.model.network.request.AirRequest.AirportApiRequest;
import com.project.triple.model.network.response.AirResponse.AirlineApiResponse;
import com.project.triple.model.network.response.AirResponse.AirportApiResponse;
import com.project.triple.service.AirService.AirlineApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/airline")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class AirlineApiController extends CrudController<AirlineApiRequest, AirlineApiResponse, Airline> {

    private final AirlineApiLogicService airlineApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , Airline airline, MultipartFile file) throws Exception
    {
        airlineApiLogicService.write(airline, file);

        ScriptUtils.alertAndMovePage(response, "항공사 등록완료", "/Triple/adminUser");
        return null;
    }
}

