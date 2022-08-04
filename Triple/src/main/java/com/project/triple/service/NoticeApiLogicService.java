package com.project.triple.service;

import com.project.triple.model.entity.Notice;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.enumclass.AdminUserStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.NoticeApiRequest;
import com.project.triple.model.network.request.UserRequest.AdminUserApiRequest;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.repository.NoticeRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeApiLogicService extends BaseService<NoticeApiRequest, NoticeApiResponse, Notice> {

    @Autowired
    private NoticeRepository noticeRepository;

    private NoticeApiResponse response (Notice notice) {
        NoticeApiResponse noticeApiResponse = NoticeApiResponse.builder()
                .idx(notice.getIdx())
                .noticeNum(notice.getNoticeNum())
                .adminuserId(notice.getAdminUser().getUserid())
                .adminuserName(notice.getAdminUser().getName())
                .noticeType(notice.getNoticeType())
                .title(notice.getTitle())
                .content(notice.getContent())
                .uploadPath(notice.getUploadPath())
                .fileName(notice.getFileName())
                .regDate(notice.getRegDate())
                .build();
        return noticeApiResponse;
    }
    @Override
    public Header<NoticeApiResponse> create(Header<NoticeApiRequest> request) {
        NoticeApiRequest noticeApiRequest = request.getData();
        Notice notice = Notice.builder().adminuserId(noticeApiRequest.getAdminuserId())
                .adminuserName(noticeApiRequest.getAdminuserName())
                .noticeType(noticeApiRequest.getNoticeType())
                .title(noticeApiRequest.getTitle())
                .content(noticeApiRequest.getContent())
                .uploadPath(noticeApiRequest.getUploadPath())
                .fileName(noticeApiRequest.getFileName())
                .build();
        Notice newNotice = baseRepository.save(notice);
        return Header.OK(response(newNotice));
    }


    @Override
    public Header<NoticeApiResponse> read(Long id) {
        return baseRepository.findById(id).map(notice -> response(notice)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<NoticeApiResponse> update(Header<NoticeApiRequest> request) {
        NoticeApiRequest noticeApiRequest = request.getData();
        Optional<Notice> notice = baseRepository.findById(noticeApiRequest.getIdx());

        return notice.map(
                notice1 -> {
                    notice1.setNoticeType(noticeApiRequest.getNoticeType());
                    notice1.setTitle(noticeApiRequest.getTitle());
                    notice1.setContent(noticeApiRequest.getContent());
                    notice1.setFileName(noticeApiRequest.getFileName());
                    notice1.setUploadPath(noticeApiRequest.getUploadPath());
                    notice1.setRegDate(noticeApiRequest.getRegDate());
                    return notice1;
                }).map(notice1 -> baseRepository.save(notice1)).map(notice1 -> response(notice1)).map(Header::OK)
        .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Notice> notice = baseRepository.findById(id);
        return notice.map(notice1 -> {
            baseRepository.delete(notice1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }
}
