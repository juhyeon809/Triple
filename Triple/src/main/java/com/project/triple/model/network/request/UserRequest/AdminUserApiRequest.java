package com.project.triple.model.network.request.UserRequest;


import com.project.triple.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserApiRequest {
    private Long idx;
    private String userid;
    private String userpw;
    private String name;
    private LocalDateTime regDate;

}