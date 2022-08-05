package com.project.triple.service.GuideService;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.GuideType;
import com.project.triple.model.enumclass.UserStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.GuideRequest.GuideApiRequest;
import com.project.triple.model.network.request.UserRequest.UsersApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.repository.GuideRepository;
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
public class GuideApiLogicService extends BaseService<GuideApiRequest, GuideApiResponse, Guide> {

    @Autowired
    private GuideRepository guideRepository;

    private GuideApiResponse response(Guide guide){
        GuideApiResponse guideApiResponse = GuideApiResponse.builder()
                .idx(guide.getIdx())
                .title(guide.getTitle())
                .uploadPath(guide.getUploadPath())
                .fileName(guide.getFileName())
                .content(guide.getContent())
                .language(guide.getLanguage())
                .area(guide.getArea())
                .population(guide.getPopulation())
                .timeDifference(guide.getTimeDifference())
                .myth(guide.getMyth())
                .voltage(guide.getVoltage())
                .currency(guide.getCurrency())
                .countryCode(guide.getCountryCode())
                .visa(guide.getVisa())
                .prices(guide.getPrices())
                .air(guide.getAir())
                .climate(guide.getClimate())
                .bestTime(guide.getBestTime())
                .simpleConversation(guide.getSimpleConversation())
                .regDate(guide.getRegDate())
                .reviewCount(guide.getReviewCount())
                .build();
        return guideApiResponse;
    }

    @Override
    public Header<GuideApiResponse> create(Header<GuideApiRequest> request) {
//        GuideApiRequest guideApiRequest = request.getData();
//        Guide guide = Guide.builder().
//
//                .reviewCount(0)
//                .build();
//        Guide newGuide = baseRepository.save(guide);
        return null;
    }

    @Override
    public Header<GuideApiResponse> read(Long id) {
        GuideApiResponse guideApiResponse = response(guideRepository.findById(id).get());

        return Header.OK(guideApiResponse);
    }

    @Override
    public Header<GuideApiResponse> update(Header<GuideApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideApiResponse> delete(Long id) {
        Guide guide = guideRepository.findById(id).get();
        baseRepository.delete(guide);
        return Header.OK();
    }

    public void write(Guide guide, MultipartFile img1) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + img1.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        img1.transferTo(savFile);
        guide.setFileName(filename);
        guide.setUploadPath("/files/"+filename);
        guideRepository.save(guide);
    }


}
