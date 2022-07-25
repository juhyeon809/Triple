package com.project.triple.model.network.request.SpotRequest;

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
public class SpotApiRequest {
    private Long idx;
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
