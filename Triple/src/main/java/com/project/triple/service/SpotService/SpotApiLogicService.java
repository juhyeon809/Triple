package com.project.triple.service.SpotService;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.entity.Restaurant.Restaurant;
import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.SpotRequest.SpotApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.repository.SpotRepository;
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
public class SpotApiLogicService extends BaseService<SpotApiRequest, SpotApiResponse, Spot> {

    @Autowired
    private SpotRepository spotRepository;

    private SpotApiResponse response(Spot spot){
        SpotApiResponse spotApiResponse = SpotApiResponse.builder()
                .idx(spot.getIdx())
                .country(spot.getCountry())
                .city(spot.getCity())
                .placeName(spot.getPlaceName())
                .title(spot.getTitle())
                .uploadPath1(spot.getUploadPath1())
                .fileName1(spot.getFileName1())
                .subtitle1(spot.getSubtitle1())
                .content1(spot.getContent1())
                .uploadPath2(spot.getUploadPath2())
                .fileName2(spot.getFileName2())
                .subtitle2(spot.getSubtitle2())
                .content2(spot.getContent2())
                .uploadPath3(spot.getUploadPath3())
                .fileName3(spot.getFileName3())
                .thing1(spot.getThing1())
                .summary1(spot.getSummary1())
                .uploadPath4(spot.getUploadPath4())
                .thing2(spot.getThing2())
                .summary2(spot.getSummary2())
                .uploadPath5(spot.getUploadPath5())
                .thing3(spot.getThing3())
                .summary3(spot.getSummary3())
                .recommendTime(spot.getRecommendTime())
                .road(spot.getRoad())
                .availableAt(spot.getAvailableAt())
                .price(spot.getPrice())
                .using(spot.getUsing())
                .regDate(spot.getRegDate())
                .likeCount(spot.getLikeCount())
                .reviewCount(spot.getReviewCount())
                .build();
        return spotApiResponse;
    }

    @Override
    public Header<SpotApiResponse> create(Header<SpotApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotApiResponse> read(Long id) {
        return spotRepository.findById(id).map(spot -> response(spot)).map(Header::OK)
                .orElseGet(()-> Header.ERROR("데이터 없음"));

    }

    @Override
    public Header<SpotApiResponse> update(Header<SpotApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotApiResponse> delete(Long id) {
        Spot spot = spotRepository.findById(id).get();
        baseRepository.delete(spot);
        return Header.OK();
    }


    public void write(Spot spot, MultipartFile img1, MultipartFile img2, MultipartFile img3, MultipartFile img4, MultipartFile img5) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        UUID uuid3 = UUID.randomUUID();
        UUID uuid4 = UUID.randomUUID();
        UUID uuid5 = UUID.randomUUID();
        String filename1 = uuid1 + "_" + img1.getOriginalFilename();
        File savFile1 = new File(projectpath, filename1);
        String filename2 = uuid2 + "_" + img2.getOriginalFilename();
        File savFile2 = new File(projectpath, filename2);
        String filename3 = uuid3 + "_" + img3.getOriginalFilename();
        File savFile3 = new File(projectpath, filename3);
        String filename4 = uuid4 + "_" + img4.getOriginalFilename();
        File savFile4 = new File(projectpath, filename4);
        String filename5 = uuid5 + "_" + img5.getOriginalFilename();
        File savFile5 = new File(projectpath, filename5);
        img1.transferTo(savFile1);
        spot.setFileName1(filename1);
        spot.setUploadPath1("/files/" + filename1);
        img2.transferTo(savFile2);
        spot.setFileName2(filename2);
        spot.setUploadPath2("/files/" + filename2);
        img3.transferTo(savFile3);
        spot.setFileName3(filename3);
        spot.setUploadPath3("/files/" + filename3);
        img4.transferTo(savFile4);
        spot.setFileName4(filename4);
        spot.setUploadPath4("/files/" + filename4);
        img5.transferTo(savFile5);
        spot.setFileName5(filename5);
        spot.setUploadPath5("/files/" + filename5);
        spotRepository.save(spot);
    }

    public Header<List<SpotApiResponse>> list() {
        List<SpotApiResponse> spotApiResponseList = spotRepository.findAllByOrderByIdxDesc().stream().map(spot -> response(spot)).collect(Collectors.toList());
        return Header.OK(spotApiResponseList);
    }

    public Header<SpotApiResponse> read3(Long postId) {

        Spot spot = spotRepository.findByIdx(postId);

        SpotApiResponse spotApiResponse = response(spot);

        return Header.OK(spotApiResponse);
    }

    public Header<List<SpotApiResponse>> search(){
        List<Spot> spotList = spotRepository.findAllByOrderByIdxDesc();
        List<SpotApiResponse> spotApiResponseList = spotList.stream()
                .map(spot -> response(spot))
                .collect(Collectors.toList());
        return Header.OK(spotApiResponseList);
    }
}
