package com.project.triple.model.network.response.GuideResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideApiResponse {
    private Long id;
    private Integer guideNum;
    private String adminuserId;
    private String country;
    private String adminuserName;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private LocalDateTime regDate;
    private Integer reviewCount;
}
