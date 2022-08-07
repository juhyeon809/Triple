package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.network.request.GuideRequest.GuideApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.service.GuideService.GuideApiLogicService;
import com.project.triple.service.GuideService.GuideReviewApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/guide")    // http://localhost:9090/api/user  url 주소
@RequiredArgsConstructor
public class GuideApiController extends CrudController<GuideApiRequest, GuideApiResponse, Guide> {

    @Autowired
    private final GuideApiLogicService guideApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , Guide guide, MultipartFile file) throws Exception
    {
        guideApiLogicService.write(guide, file);

        ScriptUtils.alert( response , "가이드 작성완료!");
        return new ModelAndView("/pages/admin/spot/spotList");
    }
}
