package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.network.request.SpotRequest.SpotApiRequest;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.service.SpotService.SpotApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/tourism")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class TourismApiController extends CrudController<SpotApiRequest, SpotApiResponse, Spot> {

    @Autowired
    private final SpotApiLogicService spotApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , Spot spot, MultipartFile img1,MultipartFile img2,MultipartFile img3,MultipartFile img4,MultipartFile img5) throws Exception
    {
        spotApiLogicService.write(spot, img1, img2, img3, img4, img5);
        ScriptUtils.alert( response , "관광지 작성완료!");
        return new ModelAndView("/pages/admin/spot/spotList");
    }
}
