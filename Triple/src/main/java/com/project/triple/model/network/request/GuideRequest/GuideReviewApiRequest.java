package com.project.triple.model.network.request.GuideRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideReviewApiRequest {
    private Long id;
    private Integer reviewNum;
    private String title;
    private String content;
    private String nickname;
    private String userId;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer replyCount;
}
