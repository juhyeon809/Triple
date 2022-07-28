package com.project.triple.model.network.response.QnAResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerApiResponse {
    private Long idx;
    private Integer answerNum;
    private Long inquiryId;
    private Long adminuserId;
    private String adminuserName;
    private String title;
    private String content;
    private LocalDateTime regDate;
}
