package com.project.triple.service.SpotService;

import com.project.triple.model.entity.Restaurant.RestaurantReview;
import com.project.triple.model.entity.Spot.SpotReview;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.SpotRequest.SpotReviewApiRequest;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotReviewApiResponse;
import com.project.triple.repository.SpotReviewRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpotReviewApiLogicService extends BaseService<SpotReviewApiRequest, SpotReviewApiResponse, SpotReview> {

    @Autowired
    private SpotReviewRepository spotReviewRepository;

    private SpotReviewApiResponse response(SpotReview spotReview){
        SpotReviewApiResponse spotReviewApiResponse = SpotReviewApiResponse.builder()
                .idx(spotReview.getIdx())
                .postId(spotReview.getPostId())
                .title(spotReview.getTitle())
                .content(spotReview.getContent())
                .nickname(spotReview.getNickname())
                .uploadPath(spotReview.getUploadPath())
                .fileName(spotReview.getFileName())
                .likeCount(spotReview.getLikeCount())
                .replyCount(spotReview.getReplyCount())
                .regDate(spotReview.getRegDate())
                .starCount(spotReview.getStarCount())
                .userEmail(spotReview.getUserEmail())
                .build();
        return spotReviewApiResponse;
    }

    @Override
    public Header<SpotReviewApiResponse> create(Header<SpotReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotReviewApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<SpotReviewApiResponse> update(Header<SpotReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<SpotReviewApiResponse> delete(Long id) {
        return null;
    }

    public void write(SpotReview spotReview, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        spotReview.setFileName(filename);
        spotReview.setUploadPath("/files/"+filename);
        spotReviewRepository.save(spotReview);
    }

    public Header<List<SpotReviewApiResponse>> findReview(Long id){

        List<SpotReviewApiResponse> reviewApiResponseList = spotReviewRepository.findAllByPostId(id).stream().map(spotReview -> response(spotReview)).collect(Collectors.toList());

        return Header.OK(reviewApiResponseList);
    }

    public Header<List<SpotReviewApiResponse>> findEmail(String email){
        List<SpotReviewApiResponse> spotReviewApiResponseList = spotReviewRepository.findAllByUserEmail(email).stream()
                .map(spotReview -> response(spotReview)).collect(Collectors.toList());

        return Header.OK(spotReviewApiResponseList);
    }

    public Long findPostId(String email){
        Long postId = spotReviewRepository.findByUserEmail(email).get().getPostId();

        return postId;
    }
}
