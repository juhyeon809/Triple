package com.project.triple.service.RestaurantService;

import com.project.triple.model.entity.Restaurant.RestaurantReviewReply;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantReviewReplyApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewReplyApiResponse;
import com.project.triple.repository.RestaurantReviewReplyRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantReviewReplyApiLogicService extends BaseService<RestaurantReviewReplyApiRequest, RestaurantReviewReplyApiResponse, RestaurantReviewReply> {

    @Autowired
    private RestaurantReviewReplyRepository restaurantReviewReplyRepository;

    private RestaurantReviewReplyApiResponse response(RestaurantReviewReply restaurantReviewReply){
        RestaurantReviewReplyApiResponse restaurantReviewReplyApiResponse = RestaurantReviewReplyApiResponse.builder()
                .idx(restaurantReviewReply.getIdx())
                .replyNum(restaurantReviewReply.getReplyNum())
                .reviewNum(restaurantReviewReply.getReviewNum())
                .title(restaurantReviewReply.getTitle())
                .content(restaurantReviewReply.getContent())
                .nickname(restaurantReviewReply.getNickname())
                .likeCount(restaurantReviewReply.getLikeCount())
                .regDate(restaurantReviewReply.getRegDate())
                .userId(restaurantReviewReply.getIdx())
                .build();
        return restaurantReviewReplyApiResponse;
    }

    @Override
    public Header<RestaurantReviewReplyApiResponse> create(Header<RestaurantReviewReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantReviewReplyApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<RestaurantReviewReplyApiResponse> update(Header<RestaurantReviewReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantReviewReplyApiResponse> delete(Long id) {
        return null;
    }
}
