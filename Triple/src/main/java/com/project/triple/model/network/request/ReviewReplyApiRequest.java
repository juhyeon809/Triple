package com.project.triple.model.network.request;

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
public class ReviewReplyApiRequest {
    private Long idx;
    private Integer replyNum;
    private Integer reviewNum;
    private String title;
    private String content;
    private String nickname;
    //    private Integer userid;
    private Integer likeCount;
    private LocalDateTime regDate;
}
