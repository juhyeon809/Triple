package com.project.triple.service.GuideService;

import com.project.triple.model.entity.Guide.GuideReviewReply;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.GuideRequest.GuideReviewReplyApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideReviewReplyApiResponse;
import com.project.triple.repository.GuideReviewReplyRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class GuideReviewReplyApiLogicService extends BaseService<GuideReviewReplyApiRequest, GuideReviewReplyApiResponse, GuideReviewReply> {

    @Autowired
    private GuideReviewReplyRepository guideReviewReplyRepository;

    private GuideReviewReplyApiResponse response(GuideReviewReply guideReviewReply){
        GuideReviewReplyApiResponse guideReviewReplyApiResponse = GuideReviewReplyApiResponse.builder()
                .idx(guideReviewReply.getIdx())
                .replyNum(guideReviewReply.getReplyNum())
                .reviewNum(guideReviewReply.getReviewNum())
                .title(guideReviewReply.getTitle())
                .content(guideReviewReply.getContent())
                .nickname(guideReviewReply.getNickname())
                .likeCount(guideReviewReply.getLikeCount())
                .regDate(guideReviewReply.getRegDate())
                .userId(guideReviewReply.getIdx())
                .build();
        return guideReviewReplyApiResponse;
    }

    @Override
    public Header<GuideReviewReplyApiResponse> create(Header<GuideReviewReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideReviewReplyApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<GuideReviewReplyApiResponse> update(Header<GuideReviewReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideReviewReplyApiResponse> delete(Long id) {
        return null;
    }
}
