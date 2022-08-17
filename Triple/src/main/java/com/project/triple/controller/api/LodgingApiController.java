package com.project.triple.controller.api;

import com.project.triple.controller.page.RoomSearch;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.service.LodgingService.LodgingApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lodging")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class LodgingApiController{

    @Autowired
    private LodgingApiLogicService lodgingApiLogicService;

    @RequestMapping(value ="/search", method = {RequestMethod.POST})
    public ModelAndView viewPostMethod(@RequestBody Header<RoomSearch> request) {
        System.out.println(request.getData().getCountry());
        System.out.println(request.getData().getCity());
        System.out.println(request.getData().getCf());
        System.out.println(request.getData().getType());
        System.out.println(request.getData().getLeastPrice());
        System.out.println(request.getData().getMaxPrice());
        System.out.println(request.getData().getRank());
        System.out.println(request.getData().getReviewCount());
        List<String> typeList = List.of(request.getData().getType().split(","));
        List<String> cfList = List.of(request.getData().getCf().split(","));
        for (String type : typeList) {
            System.out.println(type);
        }
        for (String cf : cfList) {
            System.out.println(cf);
        }
        List<LodgingApiResponse> roomList = new ArrayList<>();
        roomList.clear();
        roomList = lodgingApiLogicService.room_sort(request);
        if(roomList == null){
            return new ModelAndView("/null_error").addObject("lodgingList", null);
        }
        for (LodgingApiResponse lodgingApiResponse : roomList) {
            System.out.println(lodgingApiResponse.getIdx());
        }


        return new ModelAndView("lodging_list").addObject("lodgingList", roomList);


    }

    @PostMapping("/register")
    public String register(HttpServletResponse response , Lodging lodging, MultipartFile file) throws Exception
    {
        lodgingApiLogicService.write(lodging, file);

        ScriptUtils.alertAndMovePage( response , "숙소 등록완료!", "/Triple/admin/lodgingList");
        return null;
    }
}
