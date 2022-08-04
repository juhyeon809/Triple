package com.project.triple.service;

import com.project.triple.model.entity.Faq;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.FaqApiRequest;
import com.project.triple.model.network.response.FaqApiResponse;
import com.project.triple.repository.FaqRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqApiLogicService extends BaseService<FaqApiRequest, FaqApiResponse, Faq> {

    @Autowired
    private FaqRepository faqRepository;

    private FaqApiResponse response(Faq faq) {
        FaqApiResponse faqApiResponse = FaqApiResponse.builder()
                .idx(faq.getIdx())
                .faqNum(faq.getFaqNum())
                .faqCategory(faq.getFaqCategory())
                .adminuserID(faq.getAdminUser().getIdx())
                .adminuserName(faq.getAdminuserName())
                .title(faq.getTitle())
                .content(faq.getContent())
                .uploadPath(faq.getUploadPath())
                .fileName(faq.getFileName())
                .fileType(faq.getFileType())
                .regDate(faq.getRegDate())
                .build();
        return faqApiResponse;
    }

    @Override
    public Header<FaqApiResponse> create(Header<FaqApiRequest> request) {
        return null;
    }

    @Override
    public Header<FaqApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<FaqApiResponse> update(Header<FaqApiRequest> request) {
        return null;
    }

    @Override
    public Header<FaqApiResponse> delete(Long id) {
        return null;
    }
}
