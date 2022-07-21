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
    private Long id;
    private String reviewNum;
    private String title;
    private String reviewContent;
    private String nickname;
    private String email;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private Integer likeNum;
    private LocalDateTime regDate;
    private String ticketNum;
}