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
public class TermsApiRequest {
    private Long idx;
    private String termsName;
    private LocalDateTime regDate;
    private String content;
    private String ifRequired;
    private String ifUse;
}
