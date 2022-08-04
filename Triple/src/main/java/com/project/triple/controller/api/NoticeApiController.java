package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.NoticeApiRequest;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.service.NoticeApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/notice")    // http://localhost:9090/api/admin/notice  url 주소
@RequiredArgsConstructor
public class NoticeApiController extends CrudController<NoticeApiRequest, NoticeApiResponse, Notice> {

    private final NoticeApiLogicService noticeApiLogicService;

    @Override
    @PostMapping("")    // http://localhost:9090/api/admin/notice (post)
    public Header<NoticeApiResponse> create(@RequestBody Header<NoticeApiRequest> request) {
        return noticeApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // http://localhost:9090/api/admin/notice/{id} (get)
    public Header<NoticeApiResponse> read(@PathVariable(name="id") Long id) {
        return noticeApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     // http://localhost:9090/api/admin/notice (put)
    public Header<NoticeApiResponse> update(@RequestBody Header<NoticeApiRequest> request) {
        return noticeApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")  // http://localhost:9090/api/admin/notice/{id} (delete)
    public Header<NoticeApiResponse> delete(@PathVariable Long id) {
        return noticeApiLogicService.delete(id);
    }
}
