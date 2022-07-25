package com.project.triple.service.TriplerService;

import com.project.triple.model.entity.Tirpler.Tripler;
import com.project.triple.model.entity.Tirpler.TriplerReply;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.TriplerRequest.TriplerReplyApiRequest;
import com.project.triple.model.network.response.TriplerResponse.TriplerApiResponse;
import com.project.triple.model.network.response.TriplerResponse.TriplerReplyApiResponse;
import com.project.triple.repository.TriplerReplyRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class TriplerReplyApiLogicService extends BaseService<TriplerReplyApiRequest, TriplerReplyApiResponse, TriplerReply> {

    @Autowired
    private TriplerReplyRepository triplerReplyRepository;

    private TriplerReplyApiResponse response(TriplerReply triplerReply){
        TriplerReplyApiResponse triplerReplyApiResponse = TriplerReplyApiResponse.builder()
                .idx(triplerReply.getIdx())
                .replyNum(triplerReply.getReplyNum())
                .triplerNum(triplerReply.getTriplerNum())
                .title(triplerReply.getTitle())
                .content(triplerReply.getContent())
                .nickname(triplerReply.getNickname())
                .userId(triplerReply.getUserId())
                .likeCount(triplerReply.getLikeCount())
                .regDate(triplerReply.getRegDate())
                .build();
        return triplerReplyApiResponse;
    }

    @Override
    public Header<TriplerReplyApiResponse> create(Header<TriplerReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<TriplerReplyApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TriplerReplyApiResponse> update(Header<TriplerReplyApiRequest> request) {
        return null;
    }

    @Override
    public Header<TriplerReplyApiResponse> delete(Long id) {
        return null;
    }
}
