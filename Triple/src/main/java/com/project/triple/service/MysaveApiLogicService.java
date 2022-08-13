package com.project.triple.service;

import com.project.triple.model.entity.Mysave;
import com.project.triple.model.enumclass.MagazineType;
import com.project.triple.model.enumclass.SaveType;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.MysaveApiRequest;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.model.network.response.MysaveApiResponse;
import com.project.triple.repository.MysaveRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MysaveApiLogicService extends BaseService<MysaveApiRequest, MysaveApiResponse, Mysave> {

    @Autowired
    private MysaveRepository mysaveRepository;

    private MysaveApiResponse response(Mysave mysave) {
        MysaveApiResponse mysaveApiResponse = MysaveApiResponse.builder()
                .idx(mysave.getIdx())
                .userId(mysave.getUserId())
                .itemNum(mysave.getItemNum())
                .saveYn(mysave.getSaveYn())
                .memo(mysave.getMemo())
                .saveType(mysave.getSaveType())
                .regDate(mysave.getRegDate())
                .location(mysave.getLocation())
                .title(mysave.getTitle())
                .summary(mysave.getSummary())
                .uploadPath(mysave.getUploadPath())
                .build();
        return mysaveApiResponse;

    }

    @Override
    public Header<MysaveApiResponse> create(Header<MysaveApiRequest> request) {
        MysaveApiRequest mysaveApiRequest = request.getData();
        Mysave mysave = Mysave.builder()
                .idx(mysaveApiRequest.getIdx()).userId(mysaveApiRequest.getUserId())
                .itemNum(mysaveApiRequest.getItemNum()).saveYn(mysaveApiRequest.getSaveYn())
                .memo(mysaveApiRequest.getMemo()).saveType(mysaveApiRequest.getSaveType())
                .regDate(mysaveApiRequest.getRegDate()).location(mysaveApiRequest.getLocation())
                .title(mysaveApiRequest.getTitle()).summary(mysaveApiRequest.getSummary())
                .uploadPath(mysaveApiRequest.getUploadPath()).build();
        Mysave newMysave = baseRepository.save(mysave);
        return Header.OK(response(newMysave));
    }

    @Override
    public Header<MysaveApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<MysaveApiResponse> update(Header<MysaveApiRequest> request) {
        return null;
    }

    @Override
    public Header<MysaveApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<MysaveApiResponse>> guide(Long userId){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveTypeAndUserId(SaveType.GUIDE, userId).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> spot(Long userId){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveTypeAndUserId(SaveType.SPOT, userId).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> restaurant(Long userId){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveTypeAndUserId(SaveType.RESTAURANT, userId).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> lodging(Long userId){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveTypeAndUserId(SaveType.LODGING, userId).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> tour(Long userId){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveTypeAndUserId(SaveType.TOUR, userId).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> search(Long userId){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllByUserIdOrderByIdxDesc(userId).stream()
                .map(mysave -> response(mysave)).collect(Collectors.toList());

        return Header.OK(mysaveApiResponseList);
    }
}
