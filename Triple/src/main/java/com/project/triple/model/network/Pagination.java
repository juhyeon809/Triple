package com.project.triple.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination {
    private Integer totalPages;
    private Integer totalElements;
    private Long currentPage;
    private Integer currentElements;
}
