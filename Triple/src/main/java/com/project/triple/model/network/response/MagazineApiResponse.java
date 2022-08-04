package com.project.triple.model.network.response;

import com.project.triple.model.enumclass.MagazineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagazineApiResponse {

    private Long idx;
    private String adminuserId;
    private String adminuserName;
    private MagazineType magazineType;
    private String tag;
    private String summary;
    private String title;
    private String content;
    private String uploadPath;
    private String fileName;
    private LocalDateTime regDate;
}
