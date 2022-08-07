package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.entity.Spot.SpotReview;
import com.project.triple.model.network.request.SpotRequest.SpotApiRequest;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.service.SpotService.SpotReviewApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/tour_review")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class SpotReviewApiController extends CrudController<SpotApiRequest, SpotApiResponse, Spot> {

    private final SpotReviewApiLogicService spotReviewApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , SpotReview spotReview, MultipartFile file) throws Exception
    {
        spotReviewApiLogicService.write(spotReview, file);
        Long id = spotReview.getPostId();

        ScriptUtils.alertAndMovePage( response , "리뷰 작성 완료", "/Triple/spot/tour/view/" + id);
        return null ;
    }

}
