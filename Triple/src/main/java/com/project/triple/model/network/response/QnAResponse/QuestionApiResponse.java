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
    private Long inquiryId;
    private String ticketNum;
    private String title;
    private Long userId;
    private String typeCategory;
    private String typeDetail;
    private String content;
    private String uploadpath;
    private String filename;
    private String filetype;
    private String infoAgree;
    private LocalDateTime regDate;
}
