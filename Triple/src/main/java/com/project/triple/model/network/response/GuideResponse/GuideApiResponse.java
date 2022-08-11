package com.project.triple.model.network.response.GuideResponse;

import com.project.triple.model.enumclass.GuideType;
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
    private Long idx;
    private String country;
    private String city;
    private String title;
    private String uploadPath;
    private String fileName;
    private String content;
    private String language;
    private String area;
    private String population;
    private String timeDifference;
    private String myth;
    private String voltage;
    private String currency;
    private String countryCode;
    private String visa;
    private String prices;
    private String air;
    private String climate;
    private String bestTime;
    private String simpleConversation;
    private LocalDateTime regDate;
    private Integer reviewCount;
    private Integer totalStar;
    private Double starCount;
}
