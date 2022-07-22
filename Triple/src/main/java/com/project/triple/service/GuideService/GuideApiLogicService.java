package com.project.triple.service.GuideService;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.GuideRequest.GuideApiRequest;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.repository.GuideRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class GuideApiLogicService extends BaseService<GuideApiRequest, GuideApiResponse, Guide> {

    @Autowired
    private GuideRepository guideRepository;

    private GuideApiResponse response(Guide guide){
        GuideApiResponse guideApiResponse = GuideApiResponse.builder()
                .idx(guide.getIdx())
                .guideNum(guide.getGuideNum())
                .adminuserId(guide.getAdminuserId())
                .country(guide.getCountry())
                .adminuserName(guide.getAdminuserName())
                .title(guide.getTitle())
                .content(guide.getContent())
                .uploadPath(guide.getUploadPath())
                .fileName(guide.getFileName())
                .fileType(guide.getFileType())
                .regDate(guide.getRegDate())
                .reviewCount(guide.getReviewCount())
                .build();
        return guideApiResponse;
    }

    @Override
    public Header<GuideApiResponse> create(Header<GuideApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<GuideApiResponse> update(Header<GuideApiRequest> request) {
        return null;
    }

    @Override
    public Header<GuideApiResponse> delete(Long id) {
        return null;
    }
}
