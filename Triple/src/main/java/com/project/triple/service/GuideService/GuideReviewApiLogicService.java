package com.project.triple.service.GuideService;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Guide.GuideReview;
import com.project.triple.model.entity.Spot.SpotReview;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.GuideRequest.GuideReviewApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.model.network.response.GuideResponse.GuideReviewApiResponse;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewApiResponse;
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

    @Autowired
    private GuideRepository guideRepository;

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
        return Header.OK(response(guideReviewRepository.findById(id).get()));
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
        Integer newTotal = (guide.getTotalStar() - guideReviewApiResponse.getStarCount());
        Integer newReviewCount = guide.getReviewCount() - 1;
        if(newReviewCount == 0){
            guide.setReviewCount(0);
            guide.setStarCount(0.0);
            guide.setTotalStar(0);
        }else {
            guide.setReviewCount(newReviewCount);
            guide.setTotalStar(newTotal);
            guide.setStarCount(((double)newTotal/(double)newReviewCount));
        }
        guideRepository.save(guide);
        File file = new File(guideReviewApiResponse.getUploadPath() + "\\" + guideReviewApiResponse.getFileName());
        if(file.exists()){
            file.delete();
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
        guideReview.setReplyCount(0);
        guideReview.setLikeCount(0);
        GuideReview newguideReview = guideReviewRepository.save(guideReview);
        double newStar= ((double)guide.getTotalStar() + (double)guideReview.getStarCount())/(double)(guide.getReviewCount()+1);
        guide.setStarCount(newStar);
        guide.setTotalStar(guide.getTotalStar() + guideReview.getStarCount());
        guide.setReviewCount(guide.getReviewCount()+1);
        guideApiLogicService.starCountUpdate(guide);

    }
    public void update2(GuideReview guideReview, MultipartFile file) throws Exception{
        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        guideReview.setFileName(filename);
        guideReview.setUploadPath("/files/"+filename);
        Guide guide = guideApiLogicService.read2(guideReview.getPostId());
        GuideReview orgReview = guideReviewRepository.findById(guideReview.getIdx()).get();
        double newStar= ((double)guide.getTotalStar() -(double)orgReview.getStarCount() + (double)guideReview.getStarCount())/(double)(guide.getReviewCount());
        orgReview.setTitle(guideReview.getTitle());
        orgReview.setContent(guideReview.getContent());
        orgReview.setStarCount(guideReview.getStarCount());
        guideReviewRepository.save(orgReview);
        guide.setStarCount(newStar);
        guide.setTotalStar(guide.getTotalStar() - orgReview.getStarCount() + guideReview.getStarCount());
        guideApiLogicService.starCountUpdate(guide);
    }

    public Header<List<GuideReviewApiResponse>> findReview(Long id){

        List<GuideReviewApiResponse> guideApiResponseList = guideReviewRepository.findAllByPostId(id).stream().map( guideReview-> response(guideReview)).collect(Collectors.toList());

        return Header.OK(guideApiResponseList);
    }

    public Header<List<GuideReviewApiResponse>> findEmail(String email){
        List<GuideReviewApiResponse> guideReviewApiResponseList = guideReviewRepository.findAllByUserEmail(email).stream()
                .map(guideReview -> response(guideReview)).collect(Collectors.toList());

        return Header.OK(guideReviewApiResponseList);
    }

    public Long findPostId(String email){
        Long postId = guideReviewRepository.findByUserEmail(email).get().getPostId();

        return postId;
    }
}
