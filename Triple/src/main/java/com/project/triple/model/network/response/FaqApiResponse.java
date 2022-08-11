package com.project.triple.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaqApiResponse {
    private Long idx;
    private String faqCategory;
    private String adminuserId;
    private String adminuserName;
    private String title;
    private String content;
    private LocalDateTime regDate;
}
