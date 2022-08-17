package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.MultiRowRoundTicketReservation;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.RoundTicketReservationApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.service.ReservationService.RoundTicketReservationApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/roundReservation")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class RoundReservationApiController extends CrudController<RoundTicketReservationApiRequest, RoundTicketReservationApiResponse, RoundTicketReservation> {

    private final RoundTicketReservationApiLogicService roundTicketReservationApiLogicService;

    @RequestMapping("/save")
    public Header<List<RoundTicketReservationApiResponse>> create(HttpServletResponse response , @ModelAttribute(value = "MultiRowRoundTicketReservation") MultiRowRoundTicketReservation infoList) throws IOException {

         List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationApiLogicService.reservation(infoList.getInfoList()).getData();
         for(RoundTicketReservation roundTicketReservation : infoList.getInfoList()){
             System.out.println(roundTicketReservation.getComebackTicketId());
             System.out.println(roundTicketReservation.getDepartureTicketId());
             System.out.println(roundTicketReservation.getEmail());
             System.out.println(roundTicketReservation.getBirth());
             System.out.println(roundTicketReservation.getEmail());
         }
         ScriptUtils.alertAndMovePage(response, "예약이 완료되었습니다" , "/Triple/flightMain");
        return null;
    }

    @RequestMapping("/delete")
    public Header<RoundTicketReservationApiResponse> delete(HttpServletResponse response, Long idx, String email, String name) throws IOException{
        List<RoundTicketReservationApiResponse> roundTicketReservationList = roundTicketReservationApiLogicService.list(email).getData();
        for(RoundTicketReservationApiResponse roundTicketReservationApiResponse : roundTicketReservationList){
            roundTicketReservationApiLogicService.delete(idx);
        }

        ScriptUtils.alertAndMovePage(response, name+"님의 항공권이 취소되었습니다" , "/Triple/mypage/reserve/air");
        return null;
    }

}
