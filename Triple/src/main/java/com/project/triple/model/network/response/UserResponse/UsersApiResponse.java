package com.project.triple.model.network.response.UserResponse;

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
public class UsersApiResponse {
    private Long idx;
    private String userid;
    private String email;
    private String userpw;
    private String nickname;
    private String countryCode;
    private Integer zipcode;
    private String address1;
    private String address2;
    private String address3;
    private LocalDateTime regDate;
    private UserStatus status;
    private String tosAgree;
}
