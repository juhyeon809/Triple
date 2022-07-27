package com.project.triple.service.RestaurantService;

import com.project.triple.model.entity.Restaurant.Restaurant;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantApiResponse;
import com.project.triple.repository.RestaurantRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantApiLogicService extends BaseService<RestaurantApiRequest, RestaurantApiResponse, Restaurant> {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private RestaurantApiResponse response(Restaurant restaurant){
        RestaurantApiResponse restaurantApiResponse = RestaurantApiResponse.builder()

                .idx(restaurant.getIdx())
                .type(restaurant.getType())
                .restNum(restaurant.getRestNum())
                .restName(restaurant.getRestName())
                .country(restaurant.getCountry())
                .city(restaurant.getCity())
                .hp(restaurant.getHp())
                .address(restaurant.getAddress())
                .title(restaurant.getTitle())
                .content(restaurant.getContent())
                .uploadPath(restaurant.getUploadPath())
                .fileName(restaurant.getFileName())
                .fileType(restaurant.getFileType())
                .status(restaurant.getStatus())
                .regDate(restaurant.getRegDate())
                .likeCount(restaurant.getLikeCount())
                .reviewCount(restaurant.getReviewCount())
                .build();
        return restaurantApiResponse;
    }

    @Override
    public Header<RestaurantApiResponse> create(Header<RestaurantApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<RestaurantApiResponse> update(Header<RestaurantApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantApiResponse> delete(Long id) {
        return null;
    }
}
