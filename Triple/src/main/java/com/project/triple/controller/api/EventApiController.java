package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Event;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.network.request.EventApiRequest;
import com.project.triple.model.network.request.NoticeApiRequest;
import com.project.triple.model.network.response.EventApiResponse;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.service.EventApiLogicService;
import com.project.triple.service.NoticeApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/api/admin/event")    // http://localhost:9090/api/admin/notice  url 주소
@RequiredArgsConstructor
public class EventApiController extends CrudController<EventApiRequest, EventApiResponse, Event> {
    private final EventApiLogicService eventApiLogicService;

    private final NoticeApiLogicService noticeApiLogicService;

    @PostMapping("/register")
    public ModelAndView register( HttpServletResponse response , Event event, MultipartFile file) throws Exception
    {
        eventApiLogicService.write(event, file);


        ScriptUtils.alertAndMovePage(response, "등록되었습니다", "/Triple/admin/eventList");
        return null;
    }
}
