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
public class TriplerApiResponse {
    private Long idx;
    private Integer triplerNum;
    private Long userId;
    private String country;
    private String city;
    private String nickname;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer replyCount;
}
