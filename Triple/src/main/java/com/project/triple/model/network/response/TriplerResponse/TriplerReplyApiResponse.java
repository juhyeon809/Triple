package com.project.triple.model.network.response.TriplerResponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TriplerReplyApiResponse {
    private Long idx;
    private Integer replyNum;
    private Integer triplerNum;
    private String title;
    private String content;
    private String nickname;
    private Long userId;
    private Integer likeCount;
    private LocalDateTime regDate;
}
