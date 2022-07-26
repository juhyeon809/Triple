package com.project.triple.model.network.request;

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
public class FaqApiRequest {
    private Long idx;
    private Integer faqNum;
    private String faqCategory;
    //    private Integer adminuserID;
    private String adminuserName;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private LocalDateTime regDate;
}
