package com.project.triple.service.RestaurantService;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Restaurant.Restaurant;
import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantReviewApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotReviewApiResponse;
import com.project.triple.repository.RestaurantRepository;
import com.project.triple.repository.RestaurantReviewRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantReviewApiLogicService extends BaseService<RestaurantReviewApiRequest, RestaurantReviewApiResponse, RestaurantReview> {

    @Autowired
    private RestaurantApiLogicService restaurantApiLogicService;

    @Autowired
    private RestaurantRepository restaurantRepository;

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
        return Header.OK(response(restaurantReviewRepository.findById(id).get()));
    }

    @Override
    public Header<RestaurantReviewApiResponse> update(Header<RestaurantReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantReviewApiResponse> delete(Long id) {
        return null;
    }

    public Header delete2(Long id, Long id2){
        Optional<RestaurantReview> restaurantReview = baseRepository.findById(id);
        RestaurantReviewApiResponse restaurantReviewApiResponse = restaurantReview.map(restaurantReview1 -> response(restaurantReview1)).get();
        Restaurant restaurant = restaurantApiLogicService.read2(id2);
        Integer newTotal = (restaurant.getTotalStar() - restaurantReviewApiResponse.getStarCount());
        Integer newReviewCount = restaurant.getReviewCount() -1 ;
        if(newReviewCount == 0){
            restaurant.setReviewCount(0);
            restaurant.setStarCount(0.0);
            restaurant.setTotalStar(0);
        }else{
            restaurant.setReviewCount(newReviewCount);
            restaurant.setTotalStar(newTotal);
            restaurant.setStarCount(((double)newTotal/(double)newReviewCount));
        }
        restaurantRepository.save(restaurant);
        File file = new File(restaurantReviewApiResponse.getUploadPath() + "\\" + restaurantReviewApiResponse.getFileName());
        if(file.exists()){
            file.delete();
        }
        return restaurantReview.map(restaurantReview1 -> {
            baseRepository.delete(restaurantReview1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }


    public void write(RestaurantReview restaurantReview, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        restaurantReview.setFileName(filename);
        restaurantReview.setUploadPath("/files/"+filename);
        Restaurant restaurant = restaurantApiLogicService.read2(restaurantReview.getPostId());
        restaurantReview.setReplyCount(0);
        restaurantReview.setLikeCount(0);
        RestaurantReview newrestaurantReview = restaurantReviewRepository.save(restaurantReview);
        double newStar = ((double)restaurant.getTotalStar() + (double)restaurantReview.getStarCount())/(double)(restaurant.getReviewCount()+1);
        restaurant.setStarCount(newStar);
        restaurant.setTotalStar(restaurant.getTotalStar() + restaurantReview.getStarCount());
        restaurant.setReviewCount(restaurant.getReviewCount()+1);
        restaurantApiLogicService.starCountUpdate(restaurant);
    }

    public void update2(RestaurantReview restaurantReview, MultipartFile file) throws  Exception{
        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        restaurantReview.setFileName(filename);
        restaurantReview.setUploadPath("/files/"+filename);
        Restaurant restaurant = restaurantApiLogicService.read2(restaurantReview.getPostId());
        RestaurantReview orgReview = restaurantReviewRepository.findById(restaurantReview.getIdx()).get();
        double newStar = ((double)restaurant.getTotalStar() - (double)orgReview.getStarCount() + (double)restaurantReview.getStarCount()/(double)(restaurant.getReviewCount()));
        orgReview.setTitle(restaurantReview.getTitle());
        orgReview.setContent(restaurantReview.getContent());
        orgReview.setStarCount(restaurantReview.getStarCount());
        restaurantReviewRepository.save(orgReview);
        restaurant.setStarCount(newStar);
        restaurant.setTotalStar(restaurant.getTotalStar() - orgReview.getStarCount() + restaurantReview.getStarCount());
        restaurantApiLogicService.starCountUpdate(restaurant);
    }

    public Header<List<RestaurantReviewApiResponse>> findReview(Long id){

        List<RestaurantReviewApiResponse> reviewApiResponseList = restaurantReviewRepository.findAllByPostId(id).stream().map(restaurantReview -> response(restaurantReview)).collect(Collectors.toList());

        return Header.OK(reviewApiResponseList);
    }

    public Header<List<RestaurantReviewApiResponse>> findEmail(String email){
        List<RestaurantReviewApiResponse> restaurantReviewApiResponses = restaurantReviewRepository.findAllByUserEmail(email).stream()
                .map(restaurantReview -> response(restaurantReview)).collect(Collectors.toList());

        return Header.OK(restaurantReviewApiResponses);
    }

    public Long findPostId(String email){
        Long postId = restaurantReviewRepository.findByUserEmail(email).get().getPostId();

        return postId;
    }


}
