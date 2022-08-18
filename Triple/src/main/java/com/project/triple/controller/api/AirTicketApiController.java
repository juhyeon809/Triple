package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.AirReservationInfo;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.controller.page.SearchInfo;
import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.AirRequest.AirTicketApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.service.AirService.AirTicketApiLogicService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private final AirTicketApiLogicService airTicketApiLogicService;


    @PostMapping("/register")
    public Header<AirTicketApiResponse> create(HttpServletResponse response , AirTicket airTicket) throws IOException {
        airTicketApiLogicService.write(airTicket);
        ScriptUtils.alertAndMovePage(response ,"항공권 등록 완료","/Triple/admin/airLineList");

        return null;
    }

    @PostMapping("/search")
    public ModelAndView search(HttpServletRequest request ,HttpServletResponse response, SearchInfo searchInfo) throws IOException {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }


        String departure = searchInfo.getDepartureTime();
        String comeback = searchInfo.getComebackTime();
        String airport1 = searchInfo.getDepartureAirport();
        String airport2 = searchInfo.getLandingAirport();
        departure = departure.replaceAll(",", "");
        System.out.println(departure);
        System.out.println(comeback);
        System.out.println(airport1);
        System.out.println(airport2);
        System.out.println(searchInfo.getOnewayTime());
        if(!searchInfo.getOnewayTime().isEmpty()){
            List<AirTicketApiResponse> airTicketApiResponse= airTicketApiLogicService.find_by_departureTime(airport1, airport2, searchInfo.getOnewayTime()).getData();
            if(airTicketApiResponse.isEmpty()){
                ScriptUtils.alertAndMovePage(response,"찾는 항공편이 없습니다","/Triple/flightMain" );
            }
            return new ModelAndView("/pages/flight_reservation/flight_view").addObject("email",email)
                    .addObject("nickname", nickname).addObject("airTicketList", airTicketApiResponse);
        }else{

            List<AirTicketApiResponse> airTicketApiResponse1 = airTicketApiLogicService.find_by_departureTime(airport1, airport2, departure).getData();
            List<AirTicketApiResponse> airTicketApiResponse2 = airTicketApiLogicService.find_by_departureTime(airport2, airport1, comeback).getData();
            if(airTicketApiResponse1.isEmpty()){
                ScriptUtils.alertAndMovePage(response,"출발날짜에 해당하는 항공편이 없습니다","/Triple/flightMain");
            }
            if(airTicketApiResponse2.isEmpty()){
                ScriptUtils.alertAndMovePage(response,"도착날짜에 해당하는 항공편이 없습니다","/Triple/flightMain");
            }
            return new ModelAndView("/pages/flight_reservation/flight_view_round").addObject("email",email)
                    .addObject("nickname", nickname).addObject("departureList", airTicketApiResponse1).addObject("comebackList" ,airTicketApiResponse2);
        }

    }

//    @PostMapping("/select")
//    public ModelAndView ticket_info(HttpServletResponse response , AirReservationInfo airReservationInfo) throws IOException {
//
//
//        return new ModelAndView("/pages/")
//    }



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
