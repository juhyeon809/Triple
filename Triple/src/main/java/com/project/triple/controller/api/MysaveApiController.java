package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Mysave;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.MysaveApiRequest;
import com.project.triple.model.network.response.MysaveApiResponse;
import com.project.triple.service.GuideService.GuideApiLogicService;
import com.project.triple.service.MysaveApiLogicService;
import com.project.triple.service.UserService.UsersApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/mysave")    // http://localhost:9090/api/mysave
@RequiredArgsConstructor
public class MysaveApiController extends CrudController<MysaveApiRequest, MysaveApiResponse, Mysave> {

    private final MysaveApiLogicService mysaveApiLogicService;

    @Override
    public Header<MysaveApiResponse> create(@RequestBody Header<MysaveApiRequest> request) {
        return mysaveApiLogicService.create(request);
    }

    @Override
    public Header<MysaveApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<MysaveApiResponse> update(Header<MysaveApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<MysaveApiResponse> delete(Long id) {
        return super.delete(id);
    }
}
