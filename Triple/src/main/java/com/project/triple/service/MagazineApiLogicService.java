package com.project.triple.service;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.MagazineApiRequest;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.repository.MagazineRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class MagazineApiLogicService extends BaseService<MagazineApiRequest, MagazineApiResponse, Magazine> {

    @Autowired
    private MagazineRepository magazineRepository;

    private MagazineApiResponse response(Magazine magazine){
        MagazineApiResponse magazineApiResponse = MagazineApiResponse.builder()
                .idx(magazine.getIdx())
                .adminuserId(magazine.getAdminuserId())
                .adminuserName(magazine.getAdminuserName())
                .magazineNum(magazine.getMagazineNum())
                .magazineType(magazine.getMagazineType())
                .title(magazine.getTitle())
                .content(magazine.getContent())
                .uploadPath(magazine.getUploadPath())
                .fileName(magazine.getFileName())
                .fileType(magazine.getFileType())
                .regDate(magazine.getRegDate())
                .build();
        return magazineApiResponse;
    }

    @Override
    public Header<MagazineApiResponse> create(Header<MagazineApiRequest> request) {
        return null;
    }

    @Override
    public Header<MagazineApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<MagazineApiResponse> update(Header<MagazineApiRequest> request) {
        return null;
    }

    @Override
    public Header<MagazineApiResponse> delete(Long id) {
        return null;
    }
}
