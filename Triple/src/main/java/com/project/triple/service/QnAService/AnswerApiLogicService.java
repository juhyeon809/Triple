package com.project.triple.service.QnAService;

import com.project.triple.model.entity.QnA.Answer;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.QnARequest.AnswerApiRequest;
import com.project.triple.model.network.response.QnAResponse.AnswerApiResponse;
import com.project.triple.repository.AnswerRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerApiLogicService extends BaseService<AnswerApiRequest, AnswerApiResponse, Answer> {

    @Autowired
    private AnswerRepository answerRepository;

    private AnswerApiResponse response(Answer answer){
        AnswerApiResponse answerApiResponse = AnswerApiResponse.builder()
                .idx(answer.getIdx())
                .answerNum(answer.getAnswerNum())
                .adminuserName(answer.getAdminuserName())
                .title(answer.getTitle())
                .content(answer.getContent())
                .regDate(answer.getRegDate())
                .inquiryId(answer.getQuestion().getInquiryId())
                .adminuserId(answer.getAdminUser().getIdx())
                .build();
        return answerApiResponse;
    }

    @Override
    public Header<AnswerApiResponse> create(Header<AnswerApiRequest> request) {
        return null;
    }

    @Override
    public Header<AnswerApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<AnswerApiResponse> update(Header<AnswerApiRequest> request) {
        return null;
    }

    @Override
    public Header<AnswerApiResponse> delete(Long id) {
        return null;
    }
}
