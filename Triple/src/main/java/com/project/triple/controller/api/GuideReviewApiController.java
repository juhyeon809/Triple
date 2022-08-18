package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Guide.GuideReview;
import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.network.request.GuideRequest.GuideApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.service.GuideService.GuideReviewApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/guide_review")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class GuideReviewApiController extends CrudController<GuideApiRequest, GuideApiResponse, Guide> {

    private final GuideReviewApiLogicService guideReviewApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , GuideReview guideReview, MultipartFile file) throws Exception
    {
        guideReviewApiLogicService.write(guideReview, file);
        Long id = guideReview.getPostId();

        ScriptUtils.alertAndMovePage( response , "리뷰 작성 완료", "/Triple/spot_location/view/" + id + "/1");
        return null ;
    }

    @PostMapping("/update")
    public ModelAndView update(HttpServletResponse response , GuideReview guideReview, MultipartFile file) throws Exception
    {
        guideReviewApiLogicService.update2(guideReview, file);
        Long id = guideReview.getPostId();

        ScriptUtils.alertAndMovePage( response , "리뷰 수정 완료", "/Triple/spot_location/view/" + id + "/1");
        return null ;
    }

}
