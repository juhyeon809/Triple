package com.project.triple.controller.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeCollector {
    private Long hour;
    private Long minute;
    private Long airTicketIdx;
}
