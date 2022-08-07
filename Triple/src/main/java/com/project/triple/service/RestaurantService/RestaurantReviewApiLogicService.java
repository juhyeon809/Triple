package com.project.triple.service.RestaurantService;

import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantReviewApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewApiResponse;
import com.project.triple.repository.RestaurantReviewRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantReviewApiLogicService extends BaseService<RestaurantReviewApiRequest, RestaurantReviewApiResponse, RestaurantReview> {

    @Autowired
    private RestaurantReviewRepository restaurantReviewRepository;

    private RestaurantReviewApiResponse response(RestaurantReview restaurantReview){
        RestaurantReviewApiResponse restaurantReviewApiResponse = RestaurantReviewApiResponse.builder()
                .idx(restaurantReview.getIdx())
                .reviewNum(restaurantReview.getReviewNum())
                .title(restaurantReview.getTitle())
                .content(restaurantReview.getContent())
                .nickname(restaurantReview.getNickname())
                .uploadPath(restaurantReview.getUploadPath())
                .fileName(restaurantReview.getFileName())
                .fileType(restaurantReview.getFileType())
                .likeCount(restaurantReview.getLikeCount())
                .replyCount(restaurantReview.getReplyCount())
                .regDate(restaurantReview.getRegDate())
                .starCount(restaurantReview.getStarCount())
                .userId(restaurantReview.getIdx())
                .build();
        return restaurantReviewApiResponse;
    }

    @Override
    public Header<RestaurantReviewApiResponse> create(Header<RestaurantReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantReviewApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<RestaurantReviewApiResponse> update(Header<RestaurantReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantReviewApiResponse> delete(Long id) {
        return null;
    }
}
