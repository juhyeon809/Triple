package com.project.triple.service.LodgingService;

import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingApiRequest;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class LodgingApiLogicService extends BaseService<LodgingApiRequest, LodgingApiResponse, Lodging> {

    @Autowired
    private LodgingApiLogicService lodgingApiLogicService;

    private LodgingApiResponse response(Lodging lodging){
        LodgingApiResponse lodgingApiResponse = LodgingApiResponse.builder()
                .idx(lodging.getIdx())
                .type(lodging.getType())
                .companyNum(lodging.getCompanyNum())
                .lodgingType(lodging.getLodgingType())
                .companyName(lodging.getCompanyName())
                .introducing(lodging.getIntroducing())
                .country(lodging.getCountry())
                .city(lodging.getCity())
                .address(lodging.getAddress())
                .contactHp(lodging.getContactHp())
                .representative(lodging.getRepresentative())
                .email(lodging.getEmail())
                .likeCount(lodging.getLikeCount())
                .build();
        return lodgingApiResponse;
    }

    @Override
    public Header<LodgingApiResponse> create(Header<LodgingApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<LodgingApiResponse> update(Header<LodgingApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingApiResponse> delete(Long id) {
        return null;
    }
}
