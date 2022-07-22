package com.project.triple.model.network.response.RestaurantResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantReviewApiResponse {
    private Long idx;
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

