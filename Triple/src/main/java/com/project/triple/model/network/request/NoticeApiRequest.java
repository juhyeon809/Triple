package com.project.triple.model.network.request;

import com.project.triple.model.enumclass.MagazineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeApiRequest {
    private Long idx;
    private String adminuserId;
    private String adminuserName;
    private String noticeType;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private LocalDateTime regDate;
}
