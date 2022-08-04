package com.project.triple.model.network.request;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PackageApiRequest {

    private Long idx;
    private String country;
    private String title;
    private String uploadPath;
    private String fileName;
    private String keyword;
    private Integer adultPr;
    private Integer kidPr;
    private Integer infantPr;
    private Integer adultInfantPr;
    private String program;
    private String contained;
    private String notContained;
    private String adminuserId;
    private String adminuserName;
    private LocalDateTime regDate;
}
