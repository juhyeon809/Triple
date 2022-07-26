package com.project.triple.model.network.request.TriplerRequest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TriplerApiRequest {
    private Long idx;
    private Integer triplerNum;
//    private String userId;
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
