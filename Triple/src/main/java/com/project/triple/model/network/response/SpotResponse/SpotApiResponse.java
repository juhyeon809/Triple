package com.project.triple.model.network.response.SpotResponse;

import com.project.triple.model.enumclass.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpotApiResponse {
    private Long idx;
    private String country;
    private String city;
    private String placeName;
    private String title;
    private String uploadPath1;
    private String fileName1;
    private String subtitle1;
    private String content1;
    private String uploadPath2;
    private String fileName2;
    private String subtitle2;
    private String content2;
    private String uploadPath3;
    private String fileName3;
    private String thing1;
    private String summary1;
    private String uploadPath4;
    private String fileName4;
    private String thing2;
    private String summary2;
    private String uploadPath5;
    private String fileName5;
    private String thing3;
    private String summary3;
    private String recommendTime;
    private String road;
    private String availableAt;
    private String price;
    private String using;
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer reviewCount;
}
