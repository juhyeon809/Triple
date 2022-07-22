package com.project.triple.service.QnAService;


import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.QnARequest.QuestionApiRequest;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.repository.QuestionRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionApiLogicService extends BaseService<QuestionApiRequest, QuestionApiResponse, Question> {

    @Autowired
    private QuestionRepository questionRepository;

    private QuestionApiResponse response(Question question){
        QuestionApiResponse questionApiResponse = QuestionApiResponse.builder()
                .idx(question.getIdx())
                .inquaryId(question.getInquaryId())
                .ticketNum(question.getTicketNum())
                .userId(question.getUserId())
                .typeCategory(question.getTypeCategory())
                .typeDetail(question.getTypeDetail())
                .content(question.getContent())
                .uploadPath(question.getUploadPath())
                .fileName(question.getFileName())
                .fileType(question.getFileType())
                .infoAgree(question.getInfoAgree())
                .regDate(question.getRegDate())
                .build();
        return questionApiResponse;
    }

    @Override
    public Header<QuestionApiResponse> create(Header<QuestionApiRequest> request) {
        return null;
    }

    @Override
    public Header<QuestionApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<QuestionApiResponse> update(Header<QuestionApiRequest> request) {
        return null;
    }

    @Override
    public Header<QuestionApiResponse> delete(Long id) {
        return null;
    }
}
