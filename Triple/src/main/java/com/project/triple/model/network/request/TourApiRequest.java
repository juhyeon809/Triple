package com.project.triple.model.network.request;

import com.project.triple.model.enumclass.TourStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourApiRequest {
    private Long idx;
    private String tourNum;
    private String country;
    private String address;
    private String managerName;
    private String contactNum;
    private String title;
    private String info;
    private TourStatus status;
    private Integer price;
    private String timeTaken;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer likeCount;
    private Integer remaining;
}
