package com.project.triple.model.network.request.AirRequest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirlineApiRequest {
    private Long idx;
    private String krName;
    private String enName;
    private String route;
    private String repNum;
    private String supportNum;
    private String uploadPath;
    private String fileName;
}
