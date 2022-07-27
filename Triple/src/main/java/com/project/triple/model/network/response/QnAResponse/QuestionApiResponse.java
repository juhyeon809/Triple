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
public class QuestionApiResponse {
    private Long idx;
    private Long inquaryId;
    private String ticketNum;
    private Long userId;
    private String typeCategory;
    private String typeDetail;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private String infoAgree;
    private LocalDateTime regDate;
}
