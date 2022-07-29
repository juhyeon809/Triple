package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.QnARequest.QuestionApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.service.QnAService.QuestionApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiry")    // http://localhost:9090/api/inquiry  url 주소
@RequiredArgsConstructor
public class QuestionApiController extends CrudController<QuestionApiRequest, QuestionApiResponse, Question> {

    private final QuestionApiLogicService questionApiLogicService;

    @Override
    @PostMapping("")                // http://localhost:9090/api/inquiry
    public Header<QuestionApiResponse> create(@RequestBody Header<QuestionApiRequest> request) {
        return questionApiLogicService.create(request);
    }

    @Override
    public Header<QuestionApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<QuestionApiResponse> update(Header<QuestionApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<QuestionApiResponse> delete(Long id) {
        return super.delete(id);
    }

    @GetMapping("/list")
    public Header<List<QuestionApiResponse>> findAll() {
        return questionApiLogicService.search();
    }
}
