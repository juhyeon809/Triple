package com.project.triple.service;

import com.project.triple.model.entity.Faq;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.enumclass.FaqCategory;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.FaqApiRequest;
import com.project.triple.model.network.response.FaqApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.repository.FaqRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
                .regDate(faq.getRegDate())
                .build();
        return faqApiResponse;
    }

    @Override
    public Header<FaqApiResponse> create(Header<FaqApiRequest> request) {
        FaqApiRequest faqApiRequest = request.getData();
        Faq faq = Faq.builder()
                .adminuserId(faqApiRequest.getAdminuserId())
                .adminuserName(faqApiRequest.getAdminuserName())
                .faqCategory(faqApiRequest.getFaqCategory())
                .title(faqApiRequest.getTitle())
                .content(faqApiRequest.getContent())
                .regDate(faqApiRequest.getRegDate())
                .build();
        Faq newFaq = baseRepository.save(faq);
        return Header.OK(response(newFaq));
    }
    @Override
    public Header<FaqApiResponse> read(Long id) {
        return baseRepository.findById(id).map(faq -> response(faq)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<FaqApiResponse> update(Header<FaqApiRequest> request) {
        FaqApiRequest faqApiRequest = request.getData();
        Optional<Faq> faq = baseRepository.findById(faqApiRequest.getIdx());

        return faq.map(
                        faq1 -> {
                            faq1.setAdminuserId(faqApiRequest.getAdminuserId());
                            faq1.setAdminuserName(faqApiRequest.getAdminuserName());
                            faq1.setFaqCategory(faqApiRequest.getFaqCategory());
                            faq1.setTitle(faqApiRequest.getTitle());
                            faq1.setContent(faqApiRequest.getContent());
                            faq1.setRegDate(faqApiRequest.getRegDate());
                            return faq1;
                        }).map(faq1 -> baseRepository.save(faq1)).map(faq1 -> response(faq1)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Faq> faq = baseRepository.findById(id);
        return faq.map(faq1 -> {
            baseRepository.delete(faq1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /*faq 조회*/
    public Header<List<FaqApiResponse>> search() {
        List<Faq> faqList = faqRepository.findAllByOrderByIdxDesc();
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
