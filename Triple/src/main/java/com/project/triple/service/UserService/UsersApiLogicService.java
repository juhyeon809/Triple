package com.project.triple.service.UserService;

import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.UserStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.UserRequest.UsersApiRequest;
import com.project.triple.model.network.response.UserResponse.UsersApiResponse;
import com.project.triple.repository.UsersRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class UsersApiLogicService extends BaseService<UsersApiRequest, UsersApiResponse, Users> {

    @Autowired
    private UsersRepository usersRepository;

    private UsersApiResponse response(Users users){
        UsersApiResponse usersApiResponse = UsersApiResponse.builder()
                .idx(users.getIdx())
                .email(users.getEmail())
                .userpw(users.getUserpw())
                .nickname(users.getNickname())
                .countryCode(users.getCountryCode())
                .hp(users.getHp())
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
                .hp(usersApiRequest.getHp())
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
        return baseRepository.findById(id).map(users -> response(users)).map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UsersApiResponse> update(Header<UsersApiRequest> request) {
        UsersApiRequest usersApiRequest = request.getData();
        Optional<Users> users = baseRepository.findById(usersApiRequest.getIdx());

        return users.map(
                        user -> {
                            user.setEmail(usersApiRequest.getEmail());
                            user.setUserpw(usersApiRequest.getUserpw());
                            user.setNickname(usersApiRequest.getNickname());
                            user.setCountryCode(usersApiRequest.getCountryCode());
                            user.setZipcode(usersApiRequest.getZipcode());
                            user.setAddress1(usersApiRequest.getAddress1());
                            user.setAddress2(usersApiRequest.getAddress2());
                            user.setAddress3(usersApiRequest.getAddress3());
                            user.setRegDate(usersApiRequest.getRegDate());
                            user.setStatus(usersApiRequest.getStatus());
                            user.setTosAgree(usersApiRequest.getTosAgree());
                            return user;
                        }).map(user -> baseRepository.save(user)).map(user -> response(user)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }


    @Override
    public Header delete(Long id) {
        Optional<Users> users = baseRepository.findById(id);
        return users.map(user->{
            baseRepository.delete(user);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public Header<UsersApiResponse> login(String email, String userpw){
        Optional<Users> users = usersRepository.findByEmailAndUserpw(email, userpw);

        return users.map(users1 -> response(users1)).map(Header::OK).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public int EmailCheck(String email){
        int result = 0;
        AtomicReference<String> newEmail = null;
        Optional<Users> users = usersRepository.findByEmail(email);
        users.map(user -> {
            newEmail.set(user.getEmail());
            return newEmail;
        });
        if(newEmail != null){
            result = 1;
        }
        return result;
    }
}