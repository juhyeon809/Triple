package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.NoticeApiRequest;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.service.NoticeApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/admin/notice")    // http://localhost:9090/api/admin/notice  url 주소
@RequiredArgsConstructor
public class NoticeApiController extends CrudController<NoticeApiRequest, NoticeApiResponse, Notice> {

    private final NoticeApiLogicService noticeApiLogicService;

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response , Notice notice, MultipartFile file) throws Exception
    {
        noticeApiLogicService.write(notice, file);

        ScriptUtils.alertAndMovePage(response, "등록되었습니다", "/Triple/admin/noticeList");
        return null;
    }
}
