package com.project.triple.model.network.response.SpotResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpotReviewApiResponse {
    private Long id;
    private String reviewNum;
    private String title;
    private String content;
    private String nickname;
    private String userId;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private Integer likeCount;
    private Integer replyCount;
    private LocalDateTime regDate;
    private String starCount;
}
