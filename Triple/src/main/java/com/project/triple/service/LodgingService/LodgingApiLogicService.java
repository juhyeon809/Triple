package com.project.triple.service.LodgingService;

import com.project.triple.controller.page.RoomSearch;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.enumclass.LodgingRoomStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingApiRequest;
import com.project.triple.model.network.response.CouponResponse.CouponApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingRoomApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.repository.LodgingRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LodgingApiLogicService extends BaseService<LodgingApiRequest, LodgingApiResponse, Lodging> {

    @Autowired
    private LodgingRepository lodgingRepository;

    @Autowired
    private LodgingRoomApiLogicService lodgingRoomApiLogicService;

    private LodgingApiResponse response(Lodging lodging){
        LodgingApiResponse lodgingApiResponse = LodgingApiResponse.builder()
                .idx(lodging.getIdx())
                .type(lodging.getType())
                .name(lodging.getName())
                .country(lodging.getCountry())
                .city(lodging.getCity())
                .rank(lodging.getRank())
                .uploadPath(lodging.getUploadPath())
                .fileName(lodging.getFileName())
                .info(lodging.getInfo())
                .introducing(lodging.getIntroducing())
                .address(lodging.getAddress())
                .checkIn(lodging.getCheckIn())
                .checkOut(lodging.getCheckOut())
                .policy(lodging.getPolicy())
                .cf(lodging.getCf())
                .moreInfo(lodging.getMoreInfo())
                .starCount(lodging.getStarCount())
                .reviewCount(lodging.getReviewCount())
                .totalStar(lodging.getTotalStar())
                .build();
        return lodgingApiResponse;
    }

    @Override
    public Header<LodgingApiResponse> create(Header<LodgingApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingApiResponse> read(Long id) {
        return Header.OK(response(lodgingRepository.findByIdx(id)));
    }

    @Override
    public Header<LodgingApiResponse> update(Header<LodgingApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingApiResponse> delete(Long id) {
        return null;
    }

//    public Header<List<LodgingApiResponse>> search(Long lodgingId){
//        List<LodgingApiResponse> lodgingApiResponseList = lodgingRepository.findByIdx(lodgingId).stream()
//                .map(lodging -> response(lodging)).collect(Collectors.toList());
//        return Header.OK(lodgingApiResponseList);
//    }

    public Header<LodgingApiResponse> read2(Long idx){
        Lodging lodging = lodgingRepository.findByIdx(idx);

        LodgingApiResponse lodgingApiResponse = response(lodging);

        return Header.OK(lodgingApiResponse);
    }

    public List<LodgingApiResponse> list(){
        List<LodgingApiResponse> lodgingApiResponseList = lodgingRepository.findAll().stream().map(lodging -> response(lodging)).collect(Collectors.toList());

        return lodgingApiResponseList;
    }

    public void write(Lodging lodging, MultipartFile file) throws Exception{
        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        lodging.setFileName(filename);
        lodging.setUploadPath("/files/"+filename);
        lodging.setTotalStar(0);
        lodging.setStarCount(0.0);
        lodging.setReviewCount(0);
        lodging.setCheapestPrice(0);
        lodgingRepository.save(lodging);
    }

    public List<LodgingApiResponse> room_sort(Header<RoomSearch> roomSearchHeader){
        List<LodgingApiResponse> lodgingApiResponseList = lodgingRepository.findAll().stream().map(lodging -> response(lodging)).collect(Collectors.toList());
        List<LodgingApiResponse> newList = new ArrayList<>();
        List<String> typeList = List.of(roomSearchHeader.getData().getType().split(","));
        String country = roomSearchHeader.getData().getCountry();
        String city = roomSearchHeader.getData().getCity();
        Integer rank = roomSearchHeader.getData().getRank();
        Integer reviewCount = roomSearchHeader.getData().getReviewCount();
        Integer leastPrice = roomSearchHeader.getData().getLeastPrice();
        Integer MaxPrice = roomSearchHeader.getData().getMaxPrice();
        List<String> cfList = List.of(roomSearchHeader.getData().getCf().split(","));
        if(roomSearchHeader.getData().getType() != "") {
            for (LodgingApiResponse lodgingApiResponse : lodgingApiResponseList){
                for (String type : typeList) {
                    if (lodgingApiResponse.getType().equals(type)) {
                        newList.add(lodgingApiResponse);
                    }
                }
            }
        }else{
            newList = lodgingApiResponseList;
        }
        for(LodgingApiResponse lodgingApiResponse : newList){
            int cheap = cheapestPrice(lodgingApiResponse);
            lodgingApiResponse.setCheapestPrice(cheap);
        }
        for(LodgingApiResponse lodgingApiResponse : newList) {
            System.out.println(lodgingApiResponse.getName());
        }
        System.out.println("유형 끝");
        if(newList.isEmpty()){
            return null;
        }
        if(rank != null) {
            for (int i = (newList.size() - 1); i > -1; i--) {
                LodgingApiResponse lodgingApiResponse = newList.get(i);
                if (lodgingApiResponse.getRank() < rank) {
                    newList.remove(lodgingApiResponse);
                }
            }
        }
        for(LodgingApiResponse lodgingApiResponse : newList) {
            System.out.println(lodgingApiResponse.getName());
        }
        System.out.println("랭크 끝");
        if(newList.isEmpty()){
            return null;
        }
        if(country != "") {
            for (int i = (newList.size() - 1); i > -1; i--) {
                LodgingApiResponse lodgingApiResponse = newList.get(i);
                if (!lodgingApiResponse.getCountry().equals(country)) {
                    newList.remove(lodgingApiResponse);
                }
            }
        }
        for(LodgingApiResponse lodgingApiResponse : newList) {
            System.out.println(lodgingApiResponse.getName());
        }
        System.out.println("국가 끝");
        if(newList.isEmpty()){
            return null;
        }
        if(city != "") {
            for (int i = (newList.size() - 1); i > -1; i--) {
                LodgingApiResponse lodgingApiResponse = newList.get(i);
                if (!lodgingApiResponse.getCity().equals(city)) {
                    newList.remove(lodgingApiResponse);
                }
            }
        }
        for(LodgingApiResponse lodgingApiResponse : newList) {
            System.out.println(lodgingApiResponse.getName());
        }
        System.out.println("도시 끝");
        if(newList.isEmpty()){
            return null;
        }
        if(reviewCount != null) {
            for(int i = (newList.size() - 1); i > -1; i--) {
                LodgingApiResponse lodgingApiResponse = newList.get(i);
                if(lodgingApiResponse.getStarCount() < reviewCount){
                    newList.remove(lodgingApiResponse);
                }
            }
        }
        for(LodgingApiResponse lodgingApiResponse : newList) {
            System.out.println(lodgingApiResponse.getName());
        }

        if(newList.isEmpty()){
            return null;
        }
        if(leastPrice != null && MaxPrice != null){
            for(int i = (newList.size() - 1); i > -1; i--) {
                LodgingApiResponse lodgingApiResponse = newList.get(i);
                int cheapestPrice = cheapestPrice(lodgingApiResponse);
                lodgingApiResponse.setCheapestPrice(cheapestPrice);
                if(cheapestPrice < leastPrice || cheapestPrice > MaxPrice) {
                    newList.remove(lodgingApiResponse);
                }
            }

        }
        for(LodgingApiResponse lodgingApiResponse : newList) {
            System.out.println(lodgingApiResponse.getName());
        }
        if(newList.isEmpty()){
            return null;
        }
        if(!cfList.isEmpty()){
            for (int i = (newList.size() - 1); i > -1; i--) {
                LodgingApiResponse lodgingApiResponse = newList.get(i);
                for(String cf : cfList){
                    if(!lodgingApiResponse.getCf().contains(cf)){
                        newList.remove(lodgingApiResponse);
                    }
                }
            }

        }
        if(newList.isEmpty()){
            return null;
        }

        return newList;
    }

    public int cheapestPrice(LodgingApiResponse lodgingApiResponse){
        Long companyId = lodgingApiResponse.getIdx();
        List<LodgingRoomApiResponse> lodgingRoomApiResponseList = lodgingRoomApiLogicService.same_company(companyId);
        int leastPrice = lodgingRoomApiResponseList.get(0).getPrice();
        if(lodgingRoomApiResponseList.size()!=0){

            lodgingRoomApiResponseList.get(0).getName();
        }
        if(!lodgingRoomApiResponseList.isEmpty()){

        }
        for(LodgingRoomApiResponse lodgingRoomApiResponse : lodgingRoomApiResponseList){
            if(lodgingRoomApiResponse.getPrice() < leastPrice){
                leastPrice=lodgingRoomApiResponse.getPrice();
            }
        }
        return leastPrice;
    }

    public Header<List<LodgingApiResponse>> search(){
        List<Lodging> lodgingList = lodgingRepository.findAllByOrderByIdxDesc();
        List<LodgingApiResponse> lodgingApiResponseList = lodgingList.stream()
                .map(lodging -> response(lodging))
                .collect(Collectors.toList());
        return Header.OK(lodgingApiResponseList);
    }

}
