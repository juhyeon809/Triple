package com.project.triple.controller.api;


import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.RoomId;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Reservation.RoomReservation;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReservationRequest.RoomReservationApiRequest;
import com.project.triple.model.network.response.ReservationResponse.RoomReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.service.ReservationService.RoomReservationApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roomReservation")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class RoomReservationApiController extends CrudController<RoomReservationApiRequest, RoomReservationApiResponse, RoomReservation> {

    @Autowired
    private RoomReservationApiLogicService roomReservationApiLogicService;


    @RequestMapping("/register")
    public String register(HttpServletResponse response , RoomReservation roomReservation) throws IOException {
        roomReservationApiLogicService.register(roomReservation);
        ScriptUtils.alertAndMovePage(response,"예약 되었습니다", "/Triple/lodging_company_list");
        return null;
    }
    @RequestMapping("/check")
    public HashMap<String, Object> check(HttpServletResponse response, @RequestBody RoomId roomId) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        System.out.println(roomId.getRoomId());
        List<LocalDate> localDates = new ArrayList<>();
       List<RoomReservationApiResponse> roomReservationApiResponseList =  roomReservationApiLogicService.list(roomId.getRoomId());
       for(RoomReservationApiResponse roomReservationApiResponse : roomReservationApiResponseList){
           System.out.println(roomReservationApiResponse.getIdx());
           LocalDate startDate = LocalDate.parse(roomReservationApiResponse.getStartDate(), formatter);
           LocalDate endDate = LocalDate.parse(roomReservationApiResponse.getEndDate(),formatter);
           List<LocalDate> Dates = startDate.datesUntil(endDate.plusDays(1)).collect(Collectors.toList());
           for(LocalDate localDate : Dates){
               localDates.add(localDate);
           }
       }
        for(LocalDate localDate : localDates){
            System.out.println(localDate);
        }
       HashMap<String, Object> map = new HashMap<>();
       map.put("list", localDates);
       return map;
    }

    @RequestMapping("/delete")
    public Header<RoomReservationApiResponse> delete(HttpServletResponse response, Long idx, String email, String name) throws IOException {
        List<RoomReservationApiResponse> roomReservationApiResponseList = roomReservationApiLogicService.list2(email).getData();
        for(RoomReservationApiResponse roomReservationApiResponse : roomReservationApiResponseList){
            roomReservationApiLogicService.delete2(idx);
        }

        ScriptUtils.alertAndMovePage(response, name+"님의 숙소예약이 취소되었습니다" , "/Triple/mypage/reserve/lodging");
        return null;
    }



}
