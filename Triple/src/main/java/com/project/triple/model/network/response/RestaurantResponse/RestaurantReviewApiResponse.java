package com.project.triple.model.network.response.RestaurantResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantReviewApiResponse {
    private Long idx;
    private Long postId;
    private String title;
    private String content;
    private String nickname;
    private String userEmail;
    private String uploadPath;
    private String fileName;
    private Integer likeCount;
    private Integer replyCount;
    private LocalDateTime regDate;
    private Integer starCount;
}

