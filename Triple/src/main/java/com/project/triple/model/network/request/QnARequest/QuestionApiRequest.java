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
public class QuestionApiRequest {
    private Long idx;
    private Long inquiryId;
    private Integer ticketNum;
    private Long userId;
    private String typeCategory;
    private String typeDetail;
    private String title;
    private String content;
    private String uploadpath;
    private String filename;
    private String filetype;
    private String infoAgree;
    private LocalDateTime regDate;
}
