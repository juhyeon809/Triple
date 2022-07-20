package com.project.triple.service;

import com.project.triple.model.entity.Users;
import com.project.triple.model.enumclass.UserStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.UsersApiRequest;
import com.project.triple.model.network.response.UsersApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersApiLogicService extends BaseService<UsersApiRequest, UsersApiResponse, Users> {


    private UsersApiResponse response(Users users){
        UsersApiResponse usersApiResponse = UsersApiResponse.builder()
                .id(users.getId())
                .email(users.getEmail())
                .userpw(users.getUserpw())
                .nickname(users.getNickname())
                .countryCode(users.getCountryCode())
                .zipcode(users.getZipcode())
                .address1(users.getAddress1())
                .address2(users.getAddress2())
                .address3(users.getAddress3())
                .regDate(users.getRegDate())
                .status(users.getStatus())
                .tosAgree(users.getTosAgree())
                .build();
        return usersApiResponse;
    }

    @Override
    public Header<UsersApiResponse> create(Header<UsersApiRequest> request) {
        UsersApiRequest usersApiRequest = request.getData();
        Users users = Users.builder().email(usersApiRequest.getEmail())
                .userpw(usersApiRequest.getUserpw())
                .nickname(usersApiRequest.getNickname())
                .countryCode(usersApiRequest.getCountryCode())
                .zipcode(usersApiRequest.getZipcode())
                .address1(usersApiRequest.getAddress1())
                .address2(usersApiRequest.getAddress2())
                .address3(usersApiRequest.getAddress3())
                .regDate(usersApiRequest.getRegDate())
                .status(UserStatus.REGISTERED)
                .tosAgree(usersApiRequest.getTosAgree())
                .build();
        Users newUsers = baseRepository.save(users);
        return Header.OK(response(newUsers));
    }

    @Override
    public Header<UsersApiResponse> read(Long id) {
        return baseRepository.findById(id).map(users -> response(users)).map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UsersApiResponse> update(Header<UsersApiRequest> request) {
        UsersApiRequest usersApiRequest = request.getData();
        Optional<Users> users = baseRepository.findById(usersApiRequest.getId());


        return null;
    }

    @Override
    public Header<UsersApiResponse> delete(Long id) {
        return null;
    }
}
