package com.project.triple.service.TriplerService;

import com.project.triple.model.entity.Tirpler.Tripler;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.TriplerRequest.TriplerApiRequest;
import com.project.triple.model.network.response.TriplerResponse.TriplerApiResponse;
import com.project.triple.repository.TriplerRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class TriplerApiLogicService extends BaseService<TriplerApiRequest, TriplerApiResponse, Tripler> {

    @Autowired
    private TriplerRepository triplerRepository;

    private TriplerApiResponse response(Tripler tripler){
        TriplerApiResponse triplerApiResponse = TriplerApiResponse.builder()
                .idx(tripler.getIdx())
                .triplerNum(tripler.getTriplerNum())
                .country(tripler.getCountry())
                .city(tripler.getCity())
                .nickname(tripler.getNickname())
                .title(tripler.getTitle())
                .content(tripler.getContent())
                .uploadPath(tripler.getUploadPath())
                .fileName(tripler.getFileName())
                .fileType(tripler.getFileType())
                .regDate(tripler.getRegDate())
                .likeCount(tripler.getLikeCount())
                .replyCount(tripler.getReplyCount())
                .userId(tripler.getUsers().getIdx())
                .build();
        return triplerApiResponse;
    }

    @Override
    public Header<TriplerApiResponse> create(Header<TriplerApiRequest> request) {
        return null;
    }

    @Override
    public Header<TriplerApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TriplerApiResponse> update(Header<TriplerApiRequest> request) {
        return null;
    }

    @Override
    public Header<TriplerApiResponse> delete(Long id) {
        return null;
    }
}
