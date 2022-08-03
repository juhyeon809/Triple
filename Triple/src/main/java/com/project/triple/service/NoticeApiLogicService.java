package com.project.triple.service;

import com.project.triple.model.entity.Notice;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.NoticeApiRequest;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.repository.NoticeRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeApiLogicService extends BaseService<NoticeApiRequest, NoticeApiResponse, Notice> {

    @Autowired
    private NoticeRepository noticeRepository;

    private NoticeApiResponse response (Notice notice) {
        NoticeApiResponse noticeApiResponse = NoticeApiResponse.builder()
                .idx(notice.getIdx())
                .noticeNum(notice.getNoticeNum())
                .adminuserId(notice.getAdminUser().getIdx())
                .adminuserName(notice.getAdminuserName())
                .title(notice.getTitle())
                .content(notice.getContent())
                .uploadPath(notice.getUploadPath())
                .fileName(notice.getFileName())
                .fileType(notice.getFileType())
                .regDate(notice.getRegDate())
                .build();
        return noticeApiResponse;
    }

    @Override
    public Header<NoticeApiResponse> create(Header<NoticeApiRequest> request) {
        return null;
    }

    @Override
    public Header<NoticeApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<NoticeApiResponse> update(Header<NoticeApiRequest> request) {
        return null;
    }

    @Override
    public Header<NoticeApiResponse> delete(Long id) {
        return null;
    }
}
