package com.project.triple.service.UserService;

import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.UserRequest.AdminUserApiRequest;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.repository.AdminUserRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

    @Autowired
    private AdminUserRepository adminUserRepository;

    private AdminUserApiResponse response(AdminUser adminUser){
        AdminUserApiResponse adminUsersApiResponse = AdminUserApiResponse.builder()
                .idx(adminUser.getIdx())
                .userid(adminUser.getUserid())
                .userpw(adminUser.getUserpw())
                .name(adminUser.getName())
                .regDate(adminUser.getRegDate())
                .build();
        return adminUsersApiResponse;
    }

    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        return null;
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        return null;
    }

    @Override
    public Header<AdminUserApiResponse> delete(Long id) {
        return null;
    }
}
