package com.project.triple.service;

import com.project.triple.model.entity.Mysave;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.MysaveApiRequest;
import com.project.triple.model.network.response.MysaveApiResponse;
import com.project.triple.repository.MysaveRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MysaveApiLogicService extends BaseService<MysaveApiRequest, MysaveApiResponse, Mysave> {

    @Autowired
    private MysaveRepository mysaveRepository;

    private MysaveApiResponse response(Mysave mysave) {
        MysaveApiResponse mysaveApiResponse = MysaveApiResponse.builder()
                .idx(mysave.getIdx())
                .userId(mysave.getUsers().getIdx())
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
}
