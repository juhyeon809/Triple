package com.project.triple.model.network.request.RestaurantRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantReviewReplyApiRequest {
    private Long id;
    private Integer replyNum;
    private Integer reviewNum;
    private String title;
    private String content;
    private String nickname;
    private String userId;
    private String likeCount;
    private LocalDateTime regDate;
}
