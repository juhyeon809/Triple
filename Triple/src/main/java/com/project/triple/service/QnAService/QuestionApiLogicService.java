package com.project.triple.service.QnAService;


import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.QnARequest.QuestionApiRequest;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.repository.QuestionRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionApiLogicService extends BaseService<QuestionApiRequest, QuestionApiResponse, Question> {

    @Autowired
    private QuestionRepository questionRepository;

    private QuestionApiResponse response(Question question){
        QuestionApiResponse questionApiResponse = QuestionApiResponse.builder()
                .idx(question.getIdx())
                .typeCategory(question.getTypeCategory())
                .typeDetail(question.getTypeDetail())
                .title(question.getTitle())
                .content(question.getContent())
                .uploadpath(question.getUploadpath())
                .filename(question.getFilename())
                .filetype(question.getFiletype())
                .infoAgree(question.getInfoAgree())
                .regDate(question.getRegDate())
                .inquiryId(question.getInquiryId())
//                .ticketNum(question.getAirTicket().getTicketNum())
//                .ticketNum(question.getLodgingTicket().getTicketNum())
//                .ticketNum(question.getTourTicket().getTicketNum())
//                .userId(question.getUsers().getIdx())
                .build();
        return questionApiResponse;
    }

    @Override
    public Header<QuestionApiResponse> create(Header<QuestionApiRequest> request) {
        QuestionApiRequest questionApiRequest = request.getData();
        Question question = Question.builder()
                .typeCategory(questionApiRequest.getTypeCategory())
                .typeDetail(questionApiRequest.getTypeDetail())
                .title(questionApiRequest.getTitle())
                .content(questionApiRequest.getContent())
                .uploadpath(questionApiRequest.getUploadpath())
                .filename(questionApiRequest.getFilename())
                .filetype(questionApiRequest.getFiletype())
                .infoAgree(questionApiRequest.getInfoAgree())
                .regDate(questionApiRequest.getRegDate())
                .inquiryId(questionApiRequest.getInquiryId())
                .userId(questionApiRequest.getUserId())
                .build();
        Question newQuestion = baseRepository.save(question);
        return Header.OK(response(newQuestion));
    }

    @Override
    public Header<QuestionApiResponse> read(Long id) {
        return questionRepository.findById(id).map(question -> response(question)).map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<QuestionApiResponse> update(Header<QuestionApiRequest> request) {
        return null;
    }

    @Override
    public Header<QuestionApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<QuestionApiResponse>> search(){
        List<Question> questionList = questionRepository.findAll();
        List<QuestionApiResponse> questionApiResponseList = questionList.stream()
                .map(question -> response(question))
                .collect(Collectors.toList());
        return Header.OK(questionApiResponseList);
    }

    public Header<List<QuestionApiResponse>> search2(Long userId){
        List<QuestionApiResponse> questionList = questionRepository.findAllByUserIdOrderByIdxDesc(userId).stream()
                .map(question -> response(question)).collect(Collectors.toList());

        return Header.OK(questionList);
    }


}
