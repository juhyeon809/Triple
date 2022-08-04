package com.project.triple.service.SpotService;

import com.project.triple.model.entity.Spot.TourSpotReviewReply;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.SpotRequest.TourSpotReviewReplyRequest;
import com.project.triple.model.network.response.SpotResponse.TourSpotReviewReplyResponse;
import com.project.triple.repository.TourSpotReviewReplyRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class TourSpotReviewReplyApiLogicService extends BaseService<TourSpotReviewReplyRequest, TourSpotReviewReplyResponse, TourSpotReviewReply> {

    @Autowired
    private TourSpotReviewReplyRepository tourSpotReviewReplyRepository;

    private TourSpotReviewReplyResponse response(TourSpotReviewReply tourSpotReviewReply){
        TourSpotReviewReplyResponse tourSpotReviewReplyResponse = TourSpotReviewReplyResponse.builder()
                .idx(tourSpotReviewReply.getIdx())
                .replyNum(tourSpotReviewReply.getReplyNum())
                .reviewNum(tourSpotReviewReply.getReviewNum())
                .title(tourSpotReviewReply.getTitle())
                .content(tourSpotReviewReply.getContent())
                .nickname(tourSpotReviewReply.getNickname())
                .likeCount(tourSpotReviewReply.getLikeCount())
                .regDate(tourSpotReviewReply.getRegDate())
                .userId(tourSpotReviewReply.getIdx())
                .build();
        return tourSpotReviewReplyResponse;
    }

    @Override
    public Header<TourSpotReviewReplyResponse> create(Header<TourSpotReviewReplyRequest> request) {
        return null;
    }

    @Override
    public Header<TourSpotReviewReplyResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TourSpotReviewReplyResponse> update(Header<TourSpotReviewReplyRequest> request) {
        return null;
    }

    @Override
    public Header<TourSpotReviewReplyResponse> delete(Long id) {
        return null;
    }
}
