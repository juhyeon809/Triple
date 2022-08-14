package com.project.triple.service.LodgingService;

import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.entity.Magazine;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingApiRequest;
import com.project.triple.model.network.response.CouponResponse.CouponApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingRoomApiResponse;
import com.project.triple.repository.LodgingRepository;
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
public class LodgingApiLogicService extends BaseService<LodgingApiRequest, LodgingApiResponse, Lodging> {

    @Autowired
    private LodgingRepository lodgingRepository;

    private LodgingApiResponse response(Lodging lodging){
        LodgingApiResponse lodgingApiResponse = LodgingApiResponse.builder()
                .idx(lodging.getIdx())
                .type(lodging.getType())
                .name(lodging.getName())
                .country(lodging.getCountry())
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
        lodgingRepository.save(lodging);
    }
}
