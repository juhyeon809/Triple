package com.project.triple.service.SpotService;

import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.entity.Spot.SpotReview;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.SpotRequest.SpotReviewApiRequest;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotReviewApiResponse;
import com.project.triple.repository.SpotReviewRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class SpotReviewApiLogicService extends BaseService<SpotReviewApiRequest, SpotReviewApiResponse, SpotReview> {

    @Autowired
    private SpotReviewRepository spotReviewRepository;

    private SpotReviewApiResponse response(SpotReview spotReview){
        SpotReviewApiResponse spotReviewApiResponse = SpotReviewApiResponse.builder()
                .idx(spotReview.getIdx())
                .reviewNum(spotReview.getReviewNum())
                .title(spotReview.getTitle())
                .content(spotReview.getContent())
                .nickname(spotReview.getNickname())
                .userId(spotReview.getUserId())
                .uploadPath(spotReview.getUploadPath())
                .fileName(spotReview.getFileName())
                .fileType(spotReview.getFileType())
                .likeCount(spotReview.getLikeCount())
                .replyCount(spotReview.getReplyCount())
                .regDate(spotReview.getRegDate())
                .starCount(spotReview.getStarCount())
                .build();
        return spotReviewApiResponse;
    }

    @Override
    public Header<SpotReviewApiResponse> create(Header<SpotReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotReviewApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<SpotReviewApiResponse> update(Header<SpotReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotReviewApiResponse> delete(Long id) {
        return null;
    }
}
