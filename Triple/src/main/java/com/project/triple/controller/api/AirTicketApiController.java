package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirTicketApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.service.AirService.AirTicketApiLogicService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/airTicket")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class AirTicketApiController extends CrudController< AirTicketApiRequest,AirTicketApiResponse, AirTicket> {

    private final AirTicketApiLogicService airTicketApiLogicService;


    @PostMapping("/register")
    public Header<AirTicketApiResponse> create(HttpServletResponse response , AirTicket airTicket) throws IOException {
        airTicketApiLogicService.write(airTicket);
        ScriptUtils.alertAndMovePage(response ,"항공권 등록 완료","/Triple");

        return null;
    }

    @Override
    public Header<AirTicketApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<AirTicketApiResponse> update(Header<AirTicketApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<AirTicketApiResponse> delete(Long id) {
        return super.delete(id);
    }




}
