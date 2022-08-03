package com.project.triple.service;

import com.project.triple.model.entity.Terms;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.TermsApiRequest;
import com.project.triple.model.network.response.TermsApiResponse;
import com.project.triple.repository.TermsRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TermsApiLogicService extends BaseService<TermsApiRequest, TermsApiResponse, Terms> {

    @Autowired
    private TermsRepository termsRepository;

    private TermsApiResponse response(Terms terms){
        TermsApiResponse termsApiResponses = TermsApiResponse.builder()
                .idx(terms.getIdx())
                .termsName(terms.getTermsName())
                .regDate(terms.getRegDate())
                .content(terms.getContent())
                .ifRequired(terms.getIfRequired())
                .ifUse(terms.getIfUse())
                .build();
        return termsApiResponses;
    }

    @Override
    public Header<TermsApiResponse> create(Header<TermsApiRequest> request) {
        return null;
    }

    @Override
    public Header<TermsApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TermsApiResponse> update(Header<TermsApiRequest> request) {
        return null;
    }

    @Override
    public Header<TermsApiResponse> delete(Long id) {
        return null;
    }
}
