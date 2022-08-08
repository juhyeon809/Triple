package com.project.triple.service.LodgingService;

import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingApiRequest;
import com.project.triple.model.network.response.CouponResponse.CouponApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingRoomApiResponse;
import com.project.triple.repository.LodgingRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LodgingApiLogicService extends BaseService<LodgingApiRequest, LodgingApiResponse, Lodging> {

    @Autowired
    private LodgingRepository lodgingRepository;

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
                .homepage(lodging.getHomepage())
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

//    public Header<List<LodgingApiResponse>> search(Long lodgingId){
//        List<LodgingApiResponse> lodgingApiResponseList = lodgingRepository.findByIdx(lodgingId).stream()
//                .map(lodging -> response(lodging)).collect(Collectors.toList());
//        return Header.OK(lodgingApiResponseList);
//    }

    public Header<LodgingApiResponse> read2(Long idx){
        Lodging lodging = lodgingRepository.findByIdx(idx);

        LodgingApiResponse lodgingApiResponse = response(lodging);

        return Header.OK(lodgingApiResponse);
    }
}
