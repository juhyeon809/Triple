package com.project.triple.service.RestaurantService;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Restaurant.Restaurant;
import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.RestaurantRequest.RestaurantApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.repository.RestaurantRepository;
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
public class RestaurantApiLogicService extends BaseService<RestaurantApiRequest, RestaurantApiResponse, Restaurant> {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private RestaurantApiResponse response(Restaurant restaurant){
        RestaurantApiResponse restaurantApiResponse = RestaurantApiResponse.builder()
                .idx(restaurant.getIdx())
                .country(restaurant.getCountry())
                .city(restaurant.getCity())
                .location(restaurant.getLocation())
                .title(restaurant.getTitle())
                .summary(restaurant.getSummary())
                .menuDescription1(restaurant.getMenuDescription1())
                .menuName1(restaurant.getMenuName1())
                .menuPrice1(restaurant.getMenuPrice1())
                .menuName2(restaurant.getMenuName2())
                .menuDescription2(restaurant.getMenuDescription2())
                .menuPrice2(restaurant.getMenuPrice2())
                .menuDescription3(restaurant.getMenuDescription3())
                .menuName3(restaurant.getMenuName3())
                .menuPrice3(restaurant.getMenuPrice3())
                .howTogo(restaurant.getHowTogo())
                .availableAt(restaurant.getAvailableAt())
                .tip(restaurant.getTip())
                .etc(restaurant.getEtc())
                .uploadPath1(restaurant.getUploadPath1())
                .fileName1(restaurant.getFileName1())
                .uploadPath2(restaurant.getUploadPath2())
                .fileName2(restaurant.getFileName1())
                .uploadPath3(restaurant.getUploadPath3())
                .fileName3(restaurant.getFileName3())
                .uploadPath4(restaurant.getUploadPath4())
                .adminuserId(restaurant.getAdminuserId())
                .adminuserName(restaurant.getAdminuserName())
                .regDate(restaurant.getRegDate())
                .likeCount(restaurant.getLikeCount())
                .totalStar(restaurant.getTotalStar())
                .starCount(restaurant.getStarCount())
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

        return restaurantRepository.findById(id).map(restaurant -> response(restaurant)).map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    public Restaurant read2(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).get();
        return restaurant;
    }

    @Override
    public Header<RestaurantApiResponse> update(Header<RestaurantApiRequest> request) {
        return null;
    }

    @Override
    public Header<RestaurantApiResponse> delete(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();
        baseRepository.delete(restaurant);
        return Header.OK();
    }


    public void write(Restaurant restaurant, MultipartFile restaurantpic, MultipartFile menu1img,MultipartFile menu2img,MultipartFile menu3img) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        UUID uuid3 = UUID.randomUUID();
        UUID uuid4 = UUID.randomUUID();
        String filename1 = uuid1 + "_" + restaurantpic.getOriginalFilename();
        File savFile1 = new File(projectpath, filename1);
        String filename2 = uuid2 + "_" + menu1img.getOriginalFilename();
        File savFile2 = new File(projectpath, filename2);
        String filename3 = uuid3 + "_" + menu2img.getOriginalFilename();
        File savFile3 = new File(projectpath, filename3);
        String filename4 = uuid4 + "_" + menu3img.getOriginalFilename();
        File savFile4 = new File(projectpath, filename4);
        restaurantpic.transferTo(savFile1);
        restaurant.setFileName1(filename1);
        restaurant.setUploadPath1("/files/" + filename1);
        menu1img.transferTo(savFile2);
        restaurant.setFileName2(filename2);
        restaurant.setUploadPath2("/files/" + filename2);
        menu2img.transferTo(savFile3);
        restaurant.setFileName3(filename3);
        restaurant.setUploadPath3("/files/" + filename3);
        menu3img.transferTo(savFile4);
        restaurant.setFileName4(filename4);
        restaurant.setUploadPath4("/files/" + filename4);
        restaurant.setLikeCount(0);
        restaurant.setTotalStar(0);
        restaurant.setStarCount(0.0);
        restaurant.setReviewCount(0);
        restaurantRepository.save(restaurant);
    }

    public Header<List<RestaurantApiResponse>> list(){

        List<RestaurantApiResponse> restaurantApiResponseList =  restaurantRepository.findAll().stream().map(restaurant -> response(restaurant)).collect(Collectors.toList());

        return Header.OK(restaurantApiResponseList);
    }

//    public Header<RestaurantApiResponse> read2(Long itemNum){
//        Restaurant restaurant = restaurantRepository.findByIdx(itemNum);
//
//        RestaurantApiResponse restaurantApiResponse = response(restaurant);
//
//        return Header.OK(restaurantApiResponse);
//    }
    public void starCountUpdate(Restaurant restaurant) {
        baseRepository.save(restaurant);
    }

    public Header<RestaurantApiResponse> read3(Long postId) {

        Restaurant restaurant = restaurantRepository.findByIdx(postId);

        RestaurantApiResponse restaurantApiResponse = response(restaurant);

        return Header.OK(restaurantApiResponse);
    }

    public Header<List<RestaurantApiResponse>> search(){
        List<Restaurant> restaurantList = restaurantRepository.findAllByOrderByIdxDesc();
        List<RestaurantApiResponse> restaurantApiResponseList = restaurantList.stream()
                .map(restaurant -> response(restaurant))
                .collect(Collectors.toList());
        return Header.OK(restaurantApiResponseList);
    }
}
