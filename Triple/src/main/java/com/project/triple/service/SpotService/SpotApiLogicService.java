package com.project.triple.service.SpotService;

import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.SpotRequest.SpotApiRequest;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.repository.SpotRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class SpotApiLogicService extends BaseService<SpotApiRequest, SpotApiResponse, Spot> {

    @Autowired
    private SpotRepository spotRepository;

    private SpotApiResponse response(Spot spot){
        SpotApiResponse spotApiResponse = SpotApiResponse.builder()
                .id(spot.getId())
                .spotNum(spot.getSpotNum())
                .spotName(spot.getSpotName())
                .country(spot.getCountry())
                .city(spot.getCity())
                .hp(spot.getHp())
                .title(spot.getTitle())
                .content(spot.getContent())
                .uploadPath(spot.getUploadPath())
                .fileName(spot.getFileName())
                .fileType(spot.getFileType())
                .status(spot.getStatus())
                .regDate(spot.getRegDate())
                .likeCount(spot.getLikeCount())
                .reviewCount(spot.getReviewCount())
                .build();
        return spotApiResponse;
    }

    @Override
    public Header<SpotApiResponse> create(Header<SpotApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<SpotApiResponse> update(Header<SpotApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotApiResponse> delete(Long id) {
        return null;
    }
}
