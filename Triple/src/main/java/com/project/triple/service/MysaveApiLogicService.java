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
                .userId(mysave.getUserid())
                .itemNum(mysave.getItemNum())
                .saveYn(mysave.getSaveYn())
                .memo(mysave.getMemo())
                .saveType(mysave.getSaveType())
                .regDate(mysave.getRegDate())
                .build();
        return mysaveApiResponse;

    }

    @Override
    public Header<MysaveApiResponse> create(Header<MysaveApiRequest> request) {
        return null;
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

    public Header<List<MysaveApiResponse>> list(){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAll().stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> guide(){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveType(SaveType.GUIDE).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> spot(){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveType(SaveType.SPOT).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> restaurant(){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveType(SaveType.RESTAURANT).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> lodging(){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveType(SaveType.LODGING).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }

    public Header<List<MysaveApiResponse>> tour(){
        List<MysaveApiResponse> mysaveApiResponseList = mysaveRepository.findAllBySaveType(SaveType.TOUR).stream().map(mysave -> response(mysave)).collect(Collectors.toList());
        return Header.OK(mysaveApiResponseList);
    }
}
