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
public class GuideReviewReplyApiRequest {
    private Long idx;
    private Integer replyNum;
    private Integer reviewNum;
    private String title;
    private String content;
    private String nickname;
    private String userId;
    private Integer likeCount;
    private LocalDateTime regDate;
}
