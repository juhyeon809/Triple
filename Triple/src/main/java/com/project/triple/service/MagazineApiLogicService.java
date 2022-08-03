package com.project.triple.service;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.enumclass.MagazineType;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.MagazineApiRequest;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.repository.MagazineRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MagazineApiLogicService extends BaseService<MagazineApiRequest, MagazineApiResponse, Magazine> {

    @Autowired
    private MagazineRepository magazineRepository;

    private MagazineApiResponse response(Magazine magazine){
        MagazineApiResponse magazineApiResponse = MagazineApiResponse.builder()
                .idx(magazine.getIdx())
                .adminuserName(magazine.getAdminuserName())
                .magazineNum(magazine.getMagazineNum())
                .magazineType(magazine.getMagazineType())
                .title(magazine.getTitle())
                .content(magazine.getContent())
//                .uploadPath(magazine.getUploadPath())
//                .fileName(magazine.getFileName())
//                .fileType(magazine.getFileType())
                .regDate(magazine.getRegDate())
                .adminuserId(magazine.getIdx())
                .build();
        return magazineApiResponse;
    }

    @Override
    public Header<MagazineApiResponse> create(Header<MagazineApiRequest> request) {
        MagazineApiRequest magazineApiRequest = request.getData();
        Magazine magazine = Magazine.builder().adminuserId(magazineApiRequest.getAdminuserId())
                .adminuserName(magazineApiRequest.getAdminuserName())
                .magazineNum(magazineApiRequest.getMagazineNum())
                .magazineType(magazineApiRequest.getMagazineType())
                .title(magazineApiRequest.getTitle())
                .content(magazineApiRequest.getContent()).build();
//                .uploadPath(magazineApiRequest.getUploadPath())
//                .fileName(magazineApiRequest.getFileName())
//                .fileType(magazineApiRequest.getFileType()).build();
        Magazine newMagazine = baseRepository.save(magazine);
        return Header.OK(response(newMagazine));
    }

    @Override
    public Header<MagazineApiResponse> read(Long id) {

        Magazine magazine = magazineRepository.findByIdx(id);

        MagazineApiResponse magazineApiResponse = response(magazine);


        return Header.OK(magazineApiResponse);
    }

    @Override
    public Header<MagazineApiResponse> update(Header<MagazineApiRequest> request) {
        return null;
    }

    @Override
    public Header<MagazineApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<MagazineApiResponse>> list(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAll().stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }

    public Header<List<MagazineApiResponse>> recommend(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAllByMagazineType(MagazineType.RECOMMEND).stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }
    public Header<List<MagazineApiResponse>> tip(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAllByMagazineType(MagazineType.TIP).stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }
    public Header<List<MagazineApiResponse>> restaurant(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAllByMagazineType(MagazineType.RESTAURANT).stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }
    public Header<List<MagazineApiResponse>> air(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAllByMagazineType(MagazineType.AIR).stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }
    public Header<List<MagazineApiResponse>> lodging(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAllByMagazineType(MagazineType.LODGING).stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }
    public Header<List<MagazineApiResponse>> tourTicket(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAllByMagazineType(MagazineType.TOURTICKET).stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }
    public Header<List<MagazineApiResponse>> shopping(){
        List<MagazineApiResponse> magazineApiResponseList = magazineRepository.findAllByMagazineType(MagazineType.SHOPPING).stream().map(magazine -> response(magazine)).collect(Collectors.toList());
        return Header.OK(magazineApiResponseList);
    }

}
