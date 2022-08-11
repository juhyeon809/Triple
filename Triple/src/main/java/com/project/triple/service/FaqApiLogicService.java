package com.project.triple.service;

import com.project.triple.model.entity.Faq;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.enumclass.FaqCategory;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.FaqApiRequest;
import com.project.triple.model.network.response.FaqApiResponse;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.repository.FaqRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FaqApiLogicService extends BaseService<FaqApiRequest, FaqApiResponse, Faq> {

    @Autowired
    private FaqRepository faqRepository;

    private FaqApiResponse response(Faq faq) {
        FaqApiResponse faqApiResponse = FaqApiResponse.builder()
                .idx(faq.getIdx())
                .faqCategory(faq.getFaqCategory())
                .adminuserId(faq.getAdminuserId())
                .adminuserName(faq.getAdminuserName())
                .title(faq.getTitle())
                .content(faq.getContent())
//                .uploadPath(faq.getUploadPath())
//                .fileName(faq.getFileName())
//                .fileType(faq.getFileType())
                .regDate(faq.getRegDate())
                .build();
        return faqApiResponse;
    }

    @Override
    public Header<FaqApiResponse> create(Header<FaqApiRequest> request) {
        return null;
    }

    @Override
    public Header<FaqApiResponse> read(Long idx) {
        Faq faq = faqRepository.findByIdx(idx);

        FaqApiResponse faqApiResponse = response(faq);

        return Header.OK(faqApiResponse);
    }

    @Override
    public Header<FaqApiResponse> update(Header<FaqApiRequest> request) {
        return null;
    }

    @Override
    public Header<FaqApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<FaqApiResponse>> search(){
        List<Faq> faqList = faqRepository.findAll();
        List<FaqApiResponse> faqApiResponseList = faqList.stream()
                .map(faq -> response(faq))
                .collect(Collectors.toList());
        return Header.OK(faqApiResponseList);
    }

    public Header<List<FaqApiResponse>> AIR(){
        List<FaqApiResponse> faqApiResponseList = faqRepository.findByFaqCategory(FaqCategory.AIR)
                .stream().map(faq -> response(faq)).collect(Collectors.toList());
        return Header.OK(faqApiResponseList);
    }

    public Header<List<FaqApiResponse>> LODGING(){
        List<FaqApiResponse> faqApiResponseList = faqRepository.findByFaqCategory(FaqCategory.LODGING)
                .stream().map(faq -> response(faq)).collect(Collectors.toList());
        return Header.OK(faqApiResponseList);
    }

    public Header<List<FaqApiResponse>> TOUR(){
        List<FaqApiResponse> faqApiResponseList = faqRepository.findByFaqCategory(FaqCategory.TOUR)
                .stream().map(faq -> response(faq)).collect(Collectors.toList());
        return Header.OK(faqApiResponseList);
    }

    public Header<List<FaqApiResponse>> SERVICE(){
        List<FaqApiResponse> faqApiResponseList = faqRepository.findByFaqCategory(FaqCategory.SERVICE)
                .stream().map(faq -> response(faq)).collect(Collectors.toList());
        return Header.OK(faqApiResponseList);
    }

    public Header<List<FaqApiResponse>> COMMON(){
        List<FaqApiResponse> faqApiResponseList = faqRepository.findByFaqCategory(FaqCategory.COMMON)
                .stream().map(faq -> response(faq)).collect(Collectors.toList());
        return Header.OK(faqApiResponseList);
    }


}
