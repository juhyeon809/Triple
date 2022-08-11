package com.project.triple.service;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.NoticeApiRequest;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.repository.NoticeRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeApiLogicService extends BaseService<NoticeApiRequest, NoticeApiResponse, Notice> {

    @Autowired
    private NoticeRepository noticeRepository;

    private NoticeApiResponse response (Notice notice) {
        NoticeApiResponse noticeApiResponse = NoticeApiResponse.builder()
                .idx(notice.getIdx())
                .adminuserId(notice.getAdminuserId())
                .adminuserName(notice.getAdminuserName())
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

//    @Override
//    public Header<NoticeApiResponse> read(Long id) {
//        return null;
//    }

//    @Override
//    public Header<NoticeApiResponse> read(Long id) {
//        return baseRepository.findById(id).map(notice -> response(notice)).map(Header::OK)
//                .orElseGet(() -> Header.ERROR("데이터 없음"));
//    }

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

    /* 공지사항 조회 */
    public Header<List<NoticeApiResponse>> search(){
        List<Notice> noticeList = noticeRepository.findAllByOrderByIdxDesc();
        List<NoticeApiResponse> noticeApiResponseList = noticeList.stream()
                .map(notice -> response(notice))
                .collect(Collectors.toList());
        return Header.OK(noticeApiResponseList);
    }



    public void write(Notice notice, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        notice.setFileName(filename);
        notice.setUploadPath("/files/"+filename);
        noticeRepository.save(notice);
    }

    @Override
    public Header<NoticeApiResponse> read(Long idx) {

        Notice notice = noticeRepository.findByIdx(idx);

        NoticeApiResponse noticeApiResponse = response(notice);

        return Header.OK(noticeApiResponse);
    }
}
