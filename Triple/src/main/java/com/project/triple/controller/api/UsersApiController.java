package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.controller.page.ScriptUtils;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.UserRequest.UsersApiRequest;
import com.project.triple.model.network.response.UserResponse.UsersApiResponse;
import com.project.triple.service.UserService.UsersApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/api/user")    // http://localhost:8080/api/user  url 주소
@RequiredArgsConstructor
public class UsersApiController extends CrudController<UsersApiRequest, UsersApiResponse, Users> {
    private final UsersApiLogicService usersApiLogicService;
    /*
                {
                    "transaction_time":"2022-07-22",
                    "resultCode":"ok",
                    "description":"ok",
                    "data":{
                        "userid":"apple",
                        "userpw":"1234",
                        "email":"apple@apple.com",
                        "nickname":"김사과",
                        "countryCode":"82",
                        "status":"REGISTERED",
                        "tosAgree":"동의"
                    }
                }

    */


    @Override
    @PostMapping("")    // http://localhost:8080/api/user (post)
    public Header<UsersApiResponse> create(@RequestBody Header<UsersApiRequest> request) {
        return usersApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // http://localhost:8080/api/user/{id} (get)
    public Header<UsersApiResponse> read(@PathVariable(name="id") Long id) {
        return usersApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     // http://localhost:8080/api/user (put)
    public Header<UsersApiResponse> update(@RequestBody Header<UsersApiRequest> request) {



        return usersApiLogicService.update(request);
    }

    @PostMapping("/serviceout")  // http://localhost:8080/api/user/{id} (delete)
    public Header<UsersApiResponse> delete(String email, String userpw) throws IOException {

        Long id = usersApiLogicService.login(email, userpw).getData().getIdx();
                usersApiLogicService.delete(id);
        return null;

    }


    @PostMapping("/emailCheck")
    @ResponseBody
    public int emailCheck(@RequestParam("email") String email){
        int cnt = usersApiLogicService.EmailCheck(email);
        return cnt;

    }

    @GetMapping("/check/sendSMS")
    @ResponseBody
    public String sendSMS(String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        UsersApiLogicService.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }

    @RequestMapping( "/pwCheck")
    @ResponseBody
    public int pwCheck(@RequestParam("userpw") String userPw) {
        int check = usersApiLogicService.PwCheck(userPw);
        return check;


    }

}
