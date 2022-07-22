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
    private Long id;
    private Integer inquaryId;
    private Integer ticketNum;
    private Integer userId;
    private String typeCategory;
    private String typeDetail;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private String infoAgree;
    private LocalDateTime regDate;
}
