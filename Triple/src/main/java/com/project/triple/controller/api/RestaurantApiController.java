package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Restaurant.Restaurant;
import com.project.triple.model.network.request.ReservationRequest.ReservationApiRequest;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantApiResponse;
import com.project.triple.service.RestaurantService.RestaurantApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/restaurant")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class RestaurantApiController extends CrudController<RestaurantApiRequest, RestaurantApiResponse, Restaurant> {


    @Autowired
    private final RestaurantApiLogicService restaurantApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , Restaurant restaurant, MultipartFile restaurantpic, MultipartFile menu1img,MultipartFile menu2img,MultipartFile menu3img ) throws Exception
    {
        restaurantApiLogicService.write(restaurant, restaurantpic, menu1img, menu2img, menu3img);

        ScriptUtils.alert( response , "맛집 작성완료!");
        return new ModelAndView("/pages/admin/spot/spotList");
    }
}
