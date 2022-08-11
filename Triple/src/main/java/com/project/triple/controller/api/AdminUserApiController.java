package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.UserRequest.AdminUserApiRequest;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.service.UserService.AdminUserApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")    // http://localhost:9090/api/admin
@RequiredArgsConstructor
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {
    private final AdminUserApiLogicService adminUserApiLogicService;

    /*
                {
                    "transaction_time":"2022-07-22",
                    "resultCode":"ok",
                    "description":"ok",
                    "data":{
                        "userid":"adminapple",
                        "userpw":"applegood123",
                        "name":"김사과",
                        "hp":"010-1111-1111",
                        "department":"관리자",
                        "email":"adminapple@apple.com",
                        "position":"ceo",
                        "status":"REGISTERED"
                    }
                }

    */

    @Override
    @PostMapping("")    // http://localhost:9090/api/admin (post)
    public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // http://localhost:9090/api/admin/{id} (get)
    public Header<AdminUserApiResponse> read(@PathVariable(name="id") Long id) {
        return adminUserApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     // http://localhost:9090/api/admin (put)
    public Header<AdminUserApiResponse> update(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.update(request);
    }

    /* 관리자 삭제 */
    @Override
    @DeleteMapping("{id}")  // http://localhost:9090/api/admin/{id} (delete)
    public Header<AdminUserApiResponse> delete(@PathVariable Long id) {
        return adminUserApiLogicService.delete(id);
    }


    @PostMapping("/adminIdCheck")
    @ResponseBody
    public int adminIdCheck(@RequestParam("userid") String userid){
        int cnt = adminUserApiLogicService.IdCheck(userid);
        return cnt;
    }



}
