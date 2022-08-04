package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirTicketApiRequest;
import com.project.triple.model.network.request.AirRequest.AirTicketSearchRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.service.AirService.AirTicketApiLogicService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/airTicket")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class AirTicketApiController extends CrudController< AirTicketApiRequest,AirTicketApiResponse, AirTicket> {

    private final AirTicketApiLogicService airTicketApiLogicService;

    @Override
    @PostMapping("")
    public Header<AirTicketApiResponse> create(@RequestBody Header<AirTicketApiRequest> request) {
        return airTicketApiLogicService.create(request);
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

    @GetMapping("/list")
    public Header<List<AirTicketApiResponse>> findAll() {
        return airTicketApiLogicService.search();
    }

    @PostMapping("/search")
    public ModelAndView search(HttpServletRequest httpServletRequest,@RequestBody Header<AirTicketSearchRequest> request) {
        HttpSession session = httpServletRequest.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<AirTicketApiResponse> airTicketApiResponseList = airTicketApiLogicService.searchTicket(request).getData();
        return new ModelAndView("/pages/flight_reservation/flight_list").addObject("airTicketList",airTicketApiResponseList).addObject("email",email).addObject("nickname", nickname);
    }
}
