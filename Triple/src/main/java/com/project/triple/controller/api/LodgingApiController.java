package com.project.triple.controller.api;

import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingRoomApiRequest;
import com.project.triple.service.LodgingService.LodgingApiLogicService;
import lombok.RequiredArgsConstructor;
import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/lodging")    // http://localhost:9090/api/magazine  url 주소
@RequiredArgsConstructor
public class LodgingApiController{

    @Autowired
    private LodgingApiLogicService lodgingApiLogicService;



    @PostMapping("/register")
    public String register(HttpServletResponse response , Lodging lodging, MultipartFile file) throws Exception
    {
        lodgingApiLogicService.write(lodging, file);

        ScriptUtils.alertAndMovePage( response , "숙소 등록완료!", "/Triple/admin/lodging_company_list");
        return null;
    }
}
