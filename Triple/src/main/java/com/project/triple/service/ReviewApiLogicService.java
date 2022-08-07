package com.project.triple.service;

import com.project.triple.model.entity.Review;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.ReviewApiRequest;
import com.project.triple.model.network.response.ReviewApiResponse;
import com.project.triple.repository.ReviewRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewApiLogicService extends BaseService<ReviewApiRequest, ReviewApiResponse, Review> {

    @Autowired
    private ReviewRepository reviewRepository;

    private ReviewApiResponse response(Review review){
        ReviewApiResponse reviewApiResponse = ReviewApiResponse.builder()
                .idx(review.getIdx())
                .reviewNum(review.getReviewNum())
                .title(review.getTitle())
                .content(review.getContent())
                .nickname(review.getNickname())
                .uploadPath(review.getUploadPath())
                .fileName(review.getFileName())
                .fileType(review.getFileType())
                .likeCount(review.getLikeCount())
                .regDate(review.getRegDate())
                .ticketNum(review.getTicketNum())
                .userId(review.getUsers().getIdx())
                .build();
        return reviewApiResponse;
    }

    @Override
    public Header<ReviewApiResponse> create(Header<ReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReviewApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ReviewApiResponse> update(Header<ReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReviewApiResponse> delete(Long id) {
        return null;
    }
}
