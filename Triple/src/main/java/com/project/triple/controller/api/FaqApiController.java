package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.model.entity.Faq;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.FaqApiRequest;
import com.project.triple.model.network.request.UserRequest.AdminUserApiRequest;
import com.project.triple.model.network.response.FaqApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.service.FaqApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin/faq")    // http://localhost:9090/api/admin/faq  url 주소
@RequiredArgsConstructor
public class FaqApiController extends CrudController<FaqApiRequest, FaqApiResponse, Faq> {

    private final FaqApiLogicService faqApiLogicService;

    @Override
    @PostMapping("")    // http://localhost:9090/api/admin/faq (post)
    public Header<FaqApiResponse> create(@RequestBody Header<FaqApiRequest> request) {
        return faqApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // http://localhost:9090/api/admin/faq/{id} (get)
    public Header<FaqApiResponse> read(@PathVariable(name="id") Long id) {
        return faqApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     // http://localhost:9090/api/admin/faq (put)
    public Header<FaqApiResponse> update(@RequestBody Header<FaqApiRequest> request) {
        return faqApiLogicService.update(request);
    }

    /* 관리자 삭제 */
    @Override
    @DeleteMapping("{id}")  // http://localhost:9090/api/admin/faq/{id} (delete)
    public Header<FaqApiResponse> delete(@PathVariable Long id) {
        return faqApiLogicService.delete(id);
    }

}
