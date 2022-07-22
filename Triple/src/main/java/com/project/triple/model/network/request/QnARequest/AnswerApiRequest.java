package com.project.triple.model.network.request.QnARequest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerApiRequest {
    private Long id;
    private Integer answerNum;
    private Integer inquaryId;
    private Integer adminuserId;
    private String adminuserName;
    private String title;
    private String content;
    private LocalDateTime regDate;
}
