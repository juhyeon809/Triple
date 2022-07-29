package com.project.triple.model.network.request;

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
public class MagazineApiRequest {

    private Long idx;
    private Integer adminuserId;
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
