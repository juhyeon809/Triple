package com.project.triple.service;

import com.project.triple.model.entity.Event;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.EventApiRequest;
import com.project.triple.model.network.response.EventApiResponse;
import com.project.triple.model.network.response.NoticeApiResponse;
import com.project.triple.repository.EventRepository;
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
public class EventApiLogicService extends BaseService<EventApiRequest, EventApiResponse, Event> {

    @Autowired
    private EventRepository eventRepository;

    private EventApiResponse response (Event event) {
        EventApiResponse eventApiResponse = EventApiResponse.builder()
                .idx(event.getIdx())
                .adminuserId(event.getAdminuserId())
                .adminuserName(event.getAdminuserName())
                .eventType(event.getEventType())
                .title(event.getTitle())
                .content(event.getContent())
                .uploadPath(event.getUploadPath())
                .fileName(event.getFileName())
                .regDate(event.getRegDate())
                .build();
        return eventApiResponse;
    }
    @Override
    public Header<EventApiResponse> create(Header<EventApiRequest> request) {
        EventApiRequest eventApiRequest = request.getData();
        Event event = Event.builder().adminuserId(eventApiRequest.getAdminuserId())
                .adminuserName(eventApiRequest.getAdminuserName())
                .eventType(eventApiRequest.getEventType())
                .title(eventApiRequest.getTitle())
                .content(eventApiRequest.getContent())
                .uploadPath(eventApiRequest.getUploadPath())
                .fileName(eventApiRequest.getFileName())
                .build();
        Event newEvent = baseRepository.save(event);
        return Header.OK(response(newEvent));
    }


    @Override
    public Header<EventApiResponse> read(Long id) {
        return baseRepository.findById(id).map(event -> response(event)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<EventApiResponse> update(Header<EventApiRequest> request) {
        EventApiRequest eventApiRequest = request.getData();
        Optional<Event> event = baseRepository.findById(eventApiRequest.getIdx());

        return event.map(
                        event1 -> {
                            event1.setEventType(eventApiRequest.getEventType());
                            event1.setTitle(eventApiRequest.getTitle());
                            event1.setContent(eventApiRequest.getContent());
                            event1.setFileName(eventApiRequest.getFileName());
                            event1.setUploadPath(eventApiRequest.getUploadPath());
                            event1.setRegDate(eventApiRequest.getRegDate());
                            return event1;
                        }).map(event1 -> baseRepository.save(event1)).map(event1 -> response(event1)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Event> event = baseRepository.findById(id);
        return event.map(event1 -> {
            baseRepository.delete(event1);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /* 이벤트 조회 */
    public Header<List<EventApiResponse>> search(){
        List<Event> eventList = eventRepository.findAllByOrderByIdxDesc();
        List<EventApiResponse> eventApiResponseList = eventList.stream()
                .map(event -> response(event))
                .collect(Collectors.toList());
        return Header.OK(eventApiResponseList);
    }



    public void write(Event event, MultipartFile file) throws Exception{

        String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();
        File savFile = new File(projectpath, filename);
        file.transferTo(savFile);
        event.setFileName(filename);
        event.setUploadPath("/files/"+filename);
        eventRepository.save(event);
    }

    public Header<EventApiResponse> read2(Long idx){
        Event event = eventRepository.findByIdx(idx);

        EventApiResponse eventApiResponse = response(event);

        return Header.OK(eventApiResponse);
    }
}
