package com.project.triple.service.RestaurantService;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantReviewApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewApiResponse;
import com.project.triple.repository.RestaurantReviewRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantReviewApiLogicService extends BaseService<RestaurantReviewApiRequest, RestaurantReviewApiResponse, RestaurantReview> {

    @Autowired
    private RestaurantReviewRepository restaurantReviewRepository;

    private RestaurantReviewApiResponse response(RestaurantReview restaurantReview){
        RestaurantReviewApiResponse restaurantReviewApiResponse = RestaurantReviewApiResponse.builder()
                .idx(restaurantReview.getIdx())
                .postId(restaurantReview.getPostId())
                .title(restaurantReview.getTitle())
                .content(restaurantReview.getContent())
                .nickname(restaurantReview.getNickname())
                .uploadPath(restaurantReview.getUploadPath())
                .fileName(restaurantReview.getFileName())
                .likeCount(restaurantReview.getLikeCount())
                .replyCount(restaurantReview.getReplyCount())
                .regDate(restaurantReview.getRegDate())
                .starCount(restaurantReview.getStarCount())
                .userEmail(restaurantReview.getUserEmail())
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

    public void write(RestaurantReview restaurantReview, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        restaurantReview.setFileName(filename);
        restaurantReview.setUploadPath("/files/"+filename);
        restaurantReviewRepository.save(restaurantReview);
    }

    public Header<List<RestaurantReviewApiResponse>> findReview(Long id){

        List<RestaurantReviewApiResponse> reviewApiResponseList = restaurantReviewRepository.findAllByPostId(id).stream().map(restaurantReview -> response(restaurantReview)).collect(Collectors.toList());

        return Header.OK(reviewApiResponseList);
    }
}
