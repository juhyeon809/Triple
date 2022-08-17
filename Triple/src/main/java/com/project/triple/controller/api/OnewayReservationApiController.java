package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.MultiRowOnewayReservation;
import com.project.triple.controller.page.MultiRowRoundTicketReservation;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Reservation.OnewayReservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.OnewayReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.OnewayReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.service.ReservationService.OnewayReservationApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/onewayReservation")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class OnewayReservationApiController extends CrudController<OnewayReservationApiRequest, OnewayReservationApiResponse, OnewayReservation> {

    private final OnewayReservationApiLogicService onewayReservationApiLogicService;

    @RequestMapping("/save")
    public Header<List<OnewayReservationApiResponse>> create(HttpServletResponse response , @ModelAttribute(value = "MultiRowOnewayReservation") MultiRowOnewayReservation infoList) throws IOException {

        List<OnewayReservationApiResponse> onewayReservationApiResponseList = onewayReservationApiLogicService.reservation(infoList.getInfoList()).getData();
        for(OnewayReservation onewayReservation : infoList.getInfoList()){
            System.out.println(onewayReservation.getIdx());
        }
        ScriptUtils.alertAndMovePage(response, "예약이 완료되었습니다" , "/Triple/flightMain");
        return null;
    }

    @RequestMapping("/delete")
    public Header<OnewayReservationApiResponse> delete(HttpServletResponse response, Long idx, String email, String name) throws IOException{
        List<OnewayReservationApiResponse> onewayReservationApiResponseList = onewayReservationApiLogicService.list(email).getData();
        for(OnewayReservationApiResponse onewayReservationApiResponse : onewayReservationApiResponseList){
            onewayReservationApiLogicService.delete(idx);
        }

        ScriptUtils.alertAndMovePage(response, name+"님의 항공권이 취소되었습니다" , "/Triple/mypage/reserve/air");
        return null;
    }
}
