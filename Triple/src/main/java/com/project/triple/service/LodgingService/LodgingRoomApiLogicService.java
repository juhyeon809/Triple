package com.project.triple.service.LodgingService;

import com.project.triple.controller.page.RoomSearch;
import com.project.triple.controller.page.SearchInfo;
import com.project.triple.model.entity.Faq;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.entity.Spot.Spot;
import com.project.triple.model.enumclass.LodgingRoomStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.LodgingRequest.LodgingRoomApiRequest;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingRoomApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingTicketApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.repository.LodgingRoomRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LodgingRoomApiLogicService extends BaseService<LodgingRoomApiRequest, LodgingRoomApiResponse, LodgingRoom> {

    @Autowired
    private LodgingRoomRepository lodgingRoomRepository;


    private LodgingRoomApiResponse response(LodgingRoom lodgingRoom){
        LodgingRoomApiResponse lodgingRoomApiResponse = LodgingRoomApiResponse.builder()
                .idx(lodgingRoom.getIdx())
                .companyId(lodgingRoom.getCompanyId())
                .name(lodgingRoom.getName())
                .roomNum(lodgingRoom.getRoomNum())
                .uploadPath(lodgingRoom.getUploadPath())
                .fileName(lodgingRoom.getFileName())
                .roomCapacity(lodgingRoom.getRoomCapacity())
                .smoking(lodgingRoom.getSmoking())
                .roomView(lodgingRoom.getRoomView())
                .width(lodgingRoom.getWidth())
                .bed(lodgingRoom.getBed())
                .introducing(lodgingRoom.getIntroducing())
                .price(lodgingRoom.getPrice())
                .likeCount(lodgingRoom.getLikeCount())
                .status(lodgingRoom.getStatus())
                .build();
        return lodgingRoomApiResponse;
    }


    @Override
    public Header<LodgingRoomApiResponse> create(Header<LodgingRoomApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingRoomApiResponse> read(Long id) {
        return Header.OK(response(lodgingRoomRepository.findById(id).get()));
    }

    @Override
    public Header<LodgingRoomApiResponse> update(Header<LodgingRoomApiRequest> request) {
        return null;
    }

    @Override
    public Header<LodgingRoomApiResponse> delete(Long id) {
        LodgingRoom lodgingRoom = lodgingRoomRepository.findById(id).get();
        baseRepository.delete(lodgingRoom);
        return Header.OK();
    }


    public Header<LodgingRoomApiResponse> read2(String roomNum){
        LodgingRoom lodgingRoom = lodgingRoomRepository.findByRoomNum(roomNum);

        LodgingRoomApiResponse lodgingRoomApiResponse = response(lodgingRoom);

        return Header.OK(lodgingRoomApiResponse);
    }

    public Long findLodgingId(String roomNum){
        Long lodgingId = lodgingRoomRepository.findByRoomNum(roomNum).getCompanyId();

        return lodgingId;
    }

    public void write(LodgingRoom lodgingRoom, MultipartFile file) throws Exception{
        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        lodgingRoom.setFileName(filename);
        lodgingRoom.setUploadPath("/files/"+filename);
        lodgingRoom.setLikeCount(0);
        lodgingRoom.setStatus(LodgingRoomStatus.AVAILABLE);
        lodgingRoomRepository.save(lodgingRoom);
    }

    public Header<List<LodgingRoomApiResponse>> available_room(){
        return Header.OK(lodgingRoomRepository.findAllByStatus(LodgingRoomStatus.AVAILABLE).stream().map(lodgingRoom -> response(lodgingRoom)).collect(Collectors.toList()));
    }

    public List<LodgingRoomApiResponse>  same_company(Long id){
        return lodgingRoomRepository.findAllByCompanyId(id).stream().map(lodgingRoom -> response(lodgingRoom)).collect(Collectors.toList());
    }

    public Header<List<LodgingRoomApiResponse>> search(){
        List<LodgingRoom> lodgingRoomList = lodgingRoomRepository.findAllByOrderByIdxDesc();
        List<LodgingRoomApiResponse> lodgingRoomApiResponseList = lodgingRoomList.stream()
                .map(lodgingRoom -> response(lodgingRoom))
                .collect(Collectors.toList());
        return Header.OK(lodgingRoomApiResponseList);
    }

}
