package com.project.triple.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewApiResponse {
    private Long idx;
    private String reviewNum;
    private String title;
    private String content;
    private String nickname;
    private Integer starCount;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private Integer likeCount;
    private LocalDateTime regDate;
    private String ticketNum;
    private Long userId;
}
