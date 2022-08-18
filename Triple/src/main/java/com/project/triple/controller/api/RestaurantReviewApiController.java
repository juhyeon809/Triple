package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Restaurant.Restaurant;
import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantReviewApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewApiResponse;
import com.project.triple.service.RestaurantService.RestaurantApiLogicService;
import com.project.triple.service.RestaurantService.RestaurantReviewApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/restaurant_review")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class RestaurantReviewApiController extends CrudController<RestaurantReviewApiRequest, RestaurantReviewApiResponse, RestaurantReview>{

    private final RestaurantReviewApiLogicService restaurantReviewApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , RestaurantReview restaurantReview, MultipartFile file) throws Exception {
        restaurantReviewApiLogicService.write(restaurantReview, file);
        Long id = restaurantReview.getPostId();

        ScriptUtils.alertAndMovePage( response , "리뷰 작성 완료", "/Triple/spot/restaurant/view/" + id+"/1");
        return null ;
    }

    @PostMapping("/update")
    public ModelAndView update(HttpServletResponse response , RestaurantReview restaurantReview, MultipartFile file) throws Exception {
        restaurantReviewApiLogicService.update2(restaurantReview, file);
        Long id = restaurantReview.getPostId();

        ScriptUtils.alertAndMovePage( response , "리뷰 수정 완료", "/Triple/spot/restaurant/view/" + id + "/1");
        return null ;
    }


}
