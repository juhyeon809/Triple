package com.project.triple.model.network.response.UserResponse;

import com.project.triple.model.enumclass.AdminUserStatus;
import com.project.triple.model.network.Header;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserApiResponse {
    private long idx;
    private String userid;
    private String userpw;
    private String name;
    private String hp;
    private String department;
    private String email;
    private String position;
    private AdminUserStatus status;
    private LocalDateTime regDate;

}
