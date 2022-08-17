package com.project.triple.controller.api;


import com.project.triple.controller.page.RoomSearch;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingRoomApiRequest;
import com.project.triple.model.network.response.LodgingResponse.LodgingRoomApiResponse;
import com.project.triple.service.LodgingService.LodgingRoomApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/room")    // http://localhost:9090/api/room  url 주소
@RequiredArgsConstructor
public class LodgingRoomApiController {

    @Autowired
    private final LodgingRoomApiLogicService lodgingRoomApiLogicService;



    @PostMapping("/register")
    public String register(HttpServletResponse response , LodgingRoom lodgingRoom, MultipartFile file) throws Exception
    {
        lodgingRoomApiLogicService.write(lodgingRoom, file);

        ScriptUtils.alertAndMovePage( response , "객실 등록완료!", "/Triple/admin/lodgingList");
        return null;
    }

}
