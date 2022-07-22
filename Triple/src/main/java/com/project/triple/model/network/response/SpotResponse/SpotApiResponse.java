package com.project.triple.model.network.response.SpotResponse;

import com.project.triple.model.enumclass.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpotApiResponse {
    private Long id;
    private Integer spotNum;
    private String spotName;
    private String country;
    private String city;
    private String hp;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private OperationStatus status;
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer reviewCount;
}
