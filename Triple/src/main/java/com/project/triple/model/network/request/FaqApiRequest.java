package com.project.triple.model.network.request;

import com.project.triple.model.enumclass.FaqCategory;
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
    private FaqCategory faqCategory;
    private String adminuserId;
    private String adminuserName;
    private String title;
    private String content;
    private LocalDateTime regDate;
}
