package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.network.request.MagazineApiRequest;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.service.MagazineApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
@RequestMapping("/api/magazine")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class MagazineApiController extends CrudController<MagazineApiRequest, MagazineApiResponse, Magazine> {

    private final MagazineApiLogicService magazineApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , Magazine magazine, MultipartFile file) throws Exception
    {
        magazineApiLogicService.write(magazine, file);

        ScriptUtils.alert( response , "매거진 작성완료!");
        return new ModelAndView("/pages/admin/magazine/magazine-list");
    }



}
