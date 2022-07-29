package com.project.triple.model.network.response;

import com.project.triple.model.enumclass.MagazineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagazineApiResponse {

    private Long idx;
    private Long adminuserId;
    private String adminuserName;
    private Integer magazineNum;
    private MagazineType magazineType;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private String fileType;
    private LocalDateTime regDate;
}
