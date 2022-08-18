package com.project.triple.service.UserService;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Reservation.RoundTicketReservation;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.UserStatus;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.UserRequest.UsersApiRequest;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.model.network.response.UserResponse.UsersApiResponse;
import com.project.triple.repository.UsersRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                            user.setUserpw(usersApiRequest.getUserpw());
                            user.setNickname(usersApiRequest.getNickname());
                            user.setZipcode(usersApiRequest.getZipcode());
                            user.setAddress1(usersApiRequest.getAddress1());
                            user.setAddress2(usersApiRequest.getAddress2());
                            user.setAddress3(usersApiRequest.getAddress3());
                            return user;
                        }).map(user -> baseRepository.save(user)).map(user -> response(user)).map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }


    @Override
    public Header delete(Long idx) {
        Optional<Users> users = baseRepository.findById(idx);
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
        int result = 1;

        if( usersRepository.findByEmail(email).isEmpty()){
            result = 0;
        }
        return result;
    }

    public Long findIdx(String email){
       Long idx = usersRepository.findByEmail(email).get().getIdx();

       return idx;
    }

    public UsersApiResponse findEmail(String email){
        UsersApiResponse email1 = response(usersRepository.findByEmail(email).get());

        return email1;
    }
    public int PwCheck(String userPw){
        int result = 1;

        if( usersRepository.findByUserpw(userPw).isEmpty()){
            result = 0;
        }
        return result;
    }

    public static void certifiedPhoneNumber(String phoneNumber, String cerNum) {


        String api_key = "NCS628FEWPSB4EVA";
        String api_secret = "SX033LV1ZOETDF5T8ALPIBLMZDVNJRYT";

        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);    // 수신전화번호
        params.put("from", "010-8987-7641");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "트리플 인증번호는" + "["+cerNum+"]" + "입니다.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

    }
    /*사용자 조회*/
    public Header<List<UsersApiResponse>> search(){
        List<Users> usersList = usersRepository.findAllByOrderByIdxDesc();
        List<UsersApiResponse> usersApiResponseList = usersList.stream()
                .map(users -> response(users))
                .collect(Collectors.toList());
        return Header.OK(usersApiResponseList);
    }

    public Header<UsersApiResponse> read2(String email) {

        Users users = usersRepository.findAllByEmail(email);

        UsersApiResponse usersApiResponse = response(users);

        return Header.OK(usersApiResponse);
    }

}
