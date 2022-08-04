package com.project.triple.service;

import com.project.triple.model.entity.ReviewReply;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReviewReplyApiRequest;
import com.project.triple.model.network.response.ReviewReplyApiResponse;
import com.project.triple.repository.ReviewReplyRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewReplyApiLogicService extends BaseService<ReviewReplyApiRequest, ReviewReplyApiResponse, ReviewReply> {

    @Autowired
    private ReviewReplyRepository reviewReplyRepository;

    private ReviewReplyApiResponse response(ReviewReply reviewReply) {
        ReviewReplyApiResponse reviewReplyApiResponse = ReviewReplyApiResponse.builder()
                .idx(reviewReply.getIdx())
                .replyNum(reviewReply.getReplyNum())
                .reviewNum(reviewReply.getReviewNum())
                .title(reviewReply.getTitle())
                .content(reviewReply.getContent())
                .nickname(reviewReply.getNickname())
                .userId(reviewReply.getUsers().getIdx())
                .likeCount(reviewReply.getLikeCount())
                .regDate(reviewReply.getRegDate())
                .build();
        return reviewReplyApiResponse;

    }

    @Override
    public Header<ReviewReplyApiResponse> create(Header<ReviewReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReviewReplyApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ReviewReplyApiResponse> update(Header<ReviewReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReviewReplyApiResponse> delete(Long id) {
        return null;
    }
}
