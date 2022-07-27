package com.project.triple.service.GuideService;

import com.project.triple.model.entity.Guide.GuideReview;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.GuideRequest.GuideReviewApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideReviewApiResponse;
import com.project.triple.repository.GuideReviewRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class GuideReviewApiLogicService extends BaseService<GuideReviewApiRequest, GuideReviewApiResponse, GuideReview> {

    @Autowired
    private GuideReviewRepository guideReviewRepository;

    private GuideReviewApiResponse response(GuideReview guideReview){
        GuideReviewApiResponse guideReviewApiResponse = GuideReviewApiResponse.builder()
                .idx(guideReview.getIdx())
                .reviewNum(guideReview.getReviewNum())
                .title(guideReview.getTitle())
                .content(guideReview.getContent())
                .nickname(guideReview.getNickname())
                .uploadPath(guideReview.getUploadPath())
                .fileName(guideReview.getFileName())
                .fileType(guideReview.getFileType())
                .regDate(guideReview.getRegDate())
                .likeCount(guideReview.getLikeCount())
                .replyCount(guideReview.getReplyCount())
                .userId(guideReview.getUsers().getIdx())
                .build();
        return guideReviewApiResponse;
    }

    @Override
    public Header<GuideReviewApiResponse> create(Header<GuideReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideReviewApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<GuideReviewApiResponse> update(Header<GuideReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideReviewApiResponse> delete(Long id) {
        return null;
    }
}
