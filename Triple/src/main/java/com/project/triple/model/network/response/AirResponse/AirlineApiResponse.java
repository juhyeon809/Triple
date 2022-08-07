package com.project.triple.model.network.response.AirResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirlineApiResponse {
    private Long idx;
    private String krName;
    private String enName;
    private String route;
    private String repNum;
    private String supportNum;
    private String uploadPath;
    private String fileName;
}
