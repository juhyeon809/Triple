package com.project.triple.model.network.request.RestaurantRequest;

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
public class RestaurantApiRequest {
    private Long idx;
    private String location;
    private String title;
    private String summary;
    private String menuName1;
    private String menuDescription1;
    private Integer menuPrice1;
    private String menuName2;
    private String menuDescription2;
    private Integer menuPrice2;
    private String menuName3;
    private String menuDescription3;
    private Integer menuPrice3;
    private String howToGO;
    private String availableAt;
    private String tip;
    private String etc;
    private String uploadPath1;
    private String fileName1;
    private String uploadPath2;
    private String fileName2;
    private String uploadPath3;
    private String fileName3;
    private String uploadPath4;
    private String fileName4;
    private String adminuserId;
    private String adminuserName;
    @CreatedDate
    private LocalDateTime regDate;
    private Integer likeCount;
    private Integer reviewCount;
}
