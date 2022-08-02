package com.project.triple.service.GuideService;

import com.project.triple.model.entity.Guide.Guide;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuideApiLogicService extends BaseService<GuideApiRequest, GuideApiResponse, Guide> {

    @Autowired
    private GuideRepository guideRepository;

    private GuideApiResponse response(Guide guide){
        GuideApiResponse guideApiResponse = GuideApiResponse.builder()
                .idx(guide.getIdx())
                .guideNum(guide.getGuideNum())
                .adminuserId(guide.getAdminuserId())
                .type(guide.getType())
                .country(guide.getCountry())
                .city(guide.getCity())
                .adminuserName(guide.getAdminuserName())
                .title(guide.getTitle())
                .content(guide.getContent())
                .uploadPath(guide.getUploadPath())
                .fileName(guide.getFileName())
                .fileType(guide.getFileType())
                .regDate(guide.getRegDate())
                .reviewCount(guide.getReviewCount())
                .adminuserId(guide.getIdx())
                .build();
        return guideApiResponse;
    }

    @Override
    public Header<GuideApiResponse> create(Header<GuideApiRequest> request) {
        GuideApiRequest guideApiRequest = request.getData();
        Guide guide = Guide.builder().
                type(guideApiRequest.getType())
                .guideNum(guideApiRequest.getGuideNum())
                .adminuserId(guideApiRequest.getAdminuserId())
                .country(guideApiRequest.getCountry())
                .city(guideApiRequest.getCity())
                .adminuserName(guideApiRequest.getAdminuserName())
                .title(guideApiRequest.getTitle())
                .content(guideApiRequest.getContent())
                .uploadPath(guideApiRequest.getUploadPath())
                .fileName(guideApiRequest.getFileName())
                .fileType(guideApiRequest.getFileType())
                .reviewCount(0)
                .build();
        Guide newGuide = baseRepository.save(guide);
        return Header.OK(response(newGuide));
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

    public Header<List<GuideApiResponse>> typeList(GuideType type) {
        List<GuideApiResponse> guideApiResponseList = guideRepository.findAllByType(type).stream().map(guide -> response(guide)).collect(Collectors.toList());

        return Header.OK(guideApiResponseList);
    }
}
