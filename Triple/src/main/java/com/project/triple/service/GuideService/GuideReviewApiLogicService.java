package com.project.triple.service.GuideService;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Guide.GuideReview;
import com.project.triple.model.entity.Spot.SpotReview;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.GuideRequest.GuideReviewApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.model.network.response.GuideResponse.GuideReviewApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotReviewApiResponse;
import com.project.triple.repository.GuideRepository;
import com.project.triple.repository.GuideReviewRepository;
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
public class GuideReviewApiLogicService extends BaseService<GuideReviewApiRequest, GuideReviewApiResponse, GuideReview> {

    @Autowired
    private GuideReviewRepository guideReviewRepository;

    @Autowired
    private GuideApiLogicService guideApiLogicService;

    private GuideReviewApiResponse response(GuideReview guideReview){
        GuideReviewApiResponse guideReviewApiResponse = GuideReviewApiResponse.builder()
                .idx(guideReview.getIdx())
                .postId(guideReview.getPostId())
                .title(guideReview.getTitle())
                .content(guideReview.getContent())
                .nickname(guideReview.getNickname())
                .uploadPath(guideReview.getUploadPath())
                .fileName(guideReview.getFileName())
                .regDate(guideReview.getRegDate())
                .likeCount(guideReview.getLikeCount())
                .replyCount(guideReview.getReplyCount())
                .userEmail(guideReview.getUserEmail())
                .starCount(guideReview.getStarCount())
                .build();
        return guideReviewApiResponse;
    }

    @Override
    public Header<GuideReviewApiResponse> create(Header<GuideReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideReviewApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<GuideReviewApiResponse> update(Header<GuideReviewApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideReviewApiResponse> delete(Long id) {
        return null;
    }

    public Header delete2(Long id, Long id2) {
        Optional<GuideReview> guideReview = baseRepository.findById(id);
        GuideReviewApiResponse guideReviewApiResponse = guideReview.map(guideReview1 -> response(guideReview1)).get();
        Guide guide = guideApiLogicService.read2(id2);
        Double newCount = (guide.getStarCount() * guide.getReviewCount()) - guideReviewApiResponse.getStarCount();
        Integer newReviewCount = guide.getReviewCount() - 1;
        Double zero = 0.0;
        if(newReviewCount == 0){
            guide.setReviewCount(newReviewCount);
            guide.setStarCount(zero);
        }else {
            guide.setReviewCount(newReviewCount);
            guide.setStarCount(newCount / newReviewCount);
        }
        return guideReview.map(guideReview1->{
            baseRepository.delete(guideReview1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public void write(GuideReview guideReview, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        guideReview.setFileName(filename);
        guideReview.setUploadPath("/files/"+filename);
        Guide guide = guideApiLogicService.read2(guideReview.getPostId());
        GuideReview newguideReview = guideReviewRepository.save(guideReview);
        Double newStar = ((guide.getStarCount() * guide.getReviewCount()) + guideReview.getStarCount())/(guide.getReviewCount()+1);
        guide.setStarCount(Double.valueOf(Math.round(newStar*100)/100));
        guide.setReviewCount(guide.getReviewCount()+1);
        guideApiLogicService.starCountUpdate(guide);

    }

    public Header<List<GuideReviewApiResponse>> findReview(Long id){

        List<GuideReviewApiResponse> guideApiResponseList = guideReviewRepository.findAllByPostId(id).stream().map( guideReview-> response(guideReview)).collect(Collectors.toList());

        return Header.OK(guideApiResponseList);
    }
}
